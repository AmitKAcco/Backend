package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.model.Requirements;
import com.auGrad.Backend.model.Selected;
import com.auGrad.Backend.services.SelectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SelectedController {

    @Autowired
    private SelectedService selectedService;

    @PostMapping("/addSelectedGrad")
    private ResponseEntity<Selected> saveJob(@RequestBody Selected selectedGrad){
        try {
            return ResponseEntity.ok().body(this.selectedService.addSelectedGrad(selectedGrad));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Error");
        }
    }

    @GetMapping("/allSelectedGrads")
    private ResponseEntity<List<Selected>> getAllSelectedGrads(){
        return ResponseEntity.ok().body(this.selectedService.getSelectedGrads());
    }

    @GetMapping("/isGradSelected/{empId}")
    private ResponseEntity<List<Selected>> getRequirementsByBatchId(@PathVariable int empId)
    {
        return ResponseEntity.ok().body(this.selectedService.isGradSelected(empId));
    }
    @GetMapping("/selectedCountByBatchId/{batchId}")
    private ResponseEntity<Integer> getEmployeeCountByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.selectedService.getEmployeesCountByBatchId(batchId));
    }


}
