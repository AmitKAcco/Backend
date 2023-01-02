package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @PostMapping("/addDashboard")
    private ResponseEntity<Dashboard> saveDashboard(@RequestBody Dashboard dashboard){
        try{
            return ResponseEntity.ok().body(this.dashboardService.createDashboard(dashboard));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Dashboard Already Exist");
        }
    }
    @GetMapping("/allDashboard")
    private ResponseEntity<List<Dashboard>> getAllDashboard(){
        return ResponseEntity.ok().body(this.dashboardService.getDashboard());
    }

    @GetMapping("/dashboardByBatchId/{batchId}")
    private ResponseEntity<Dashboard> getDashboardByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.dashboardService.getDashboardByBatchId(batchId));
    }
}
