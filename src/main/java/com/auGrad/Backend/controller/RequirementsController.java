package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.model.Requirements;
import com.auGrad.Backend.model.TrainerAssigned;
import com.auGrad.Backend.services.JobService;
import com.auGrad.Backend.services.RequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RequirementsController {
    @Autowired
    private RequirementsService requirementsService;

    @PostMapping("/addRequirements")
    private ResponseEntity<Requirements> saveRequirements(@RequestBody Requirements requirements){
        try {

            return ResponseEntity.ok().body(this.requirementsService.createRequirements(requirements));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Requirements already exists");
        }
    }

    @GetMapping("/allRequirements")
    private ResponseEntity<List<Requirements>> getAllRequirements(){
        return ResponseEntity.ok().body(this.requirementsService.getRequirements());
    }

    @GetMapping("/requirementsByBatchId/{batchId}")
    private ResponseEntity<List<Requirements>> getRequirementsByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.requirementsService.getRequirementsByBatchId(batchId));
    }
}
