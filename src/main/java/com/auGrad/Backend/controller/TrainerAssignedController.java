package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Requirements;
import com.auGrad.Backend.model.TrainerAssigned;
import com.auGrad.Backend.model.TrainingCalendar;
import com.auGrad.Backend.services.RequirementsService;
import com.auGrad.Backend.services.TrainerAssignedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainerAssignedController {
    @Autowired
    private TrainerAssignedService trainerAssignedService;

    @PostMapping("/addTrainerAssigned")
    private ResponseEntity<TrainerAssigned> saveTrainerAssigned(@RequestBody TrainerAssigned trainerAssigned){
        try {

            return ResponseEntity.ok().body(this.trainerAssignedService.createTrainerAssigned(trainerAssigned));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Trainer Assigned already exists");
        }
    }

    @GetMapping("/allTrainerAssigned")
    private ResponseEntity<List<TrainerAssigned>> getAllTrainerAssigned(){
        return ResponseEntity.ok().body(this.trainerAssignedService.getTrainerAssigned());
    }

    @GetMapping("/trainerAssignedByBatchId/{batchId}")
    private ResponseEntity<List<TrainerAssigned>> getTrainerAssignedByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.trainerAssignedService.getTrainerAssignedByBatchId(batchId));
    }
}
