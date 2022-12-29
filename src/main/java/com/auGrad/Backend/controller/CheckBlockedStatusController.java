package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.CheckBlocked;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.services.CheckBlockedService;
import com.auGrad.Backend.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckBlockedStatusController {

    @Autowired
    private CheckBlockedService checkBlockedService;

    @PostMapping("/addCheckBlocked")
    private ResponseEntity<CheckBlocked> saveCheckBlocked(@RequestBody CheckBlocked checkBlocked){
//        try {

            return ResponseEntity.ok().body(this.checkBlockedService.createCheckBlocked(checkBlocked));
//        }
//        catch (Exception e){
//            throw new NoObjectFoundException("checkBlocked already exists");
//        }
    }

    @GetMapping("/allCheckBlocked")
    private ResponseEntity<List<CheckBlocked>> getAllCheckBlocked(){
        return ResponseEntity.ok().body(this.checkBlockedService.getCheckedBlocked());
    }
}
