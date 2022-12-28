package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.TrainingCalendar;
import com.auGrad.Backend.services.BatchService;
import com.auGrad.Backend.services.TrainingCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingCalendarController {
    @Autowired
    private TrainingCalendarService trainingCalendarService;

    @PostMapping("/addTrainingCalendar")
    private ResponseEntity<TrainingCalendar> saveTrainingCalendar(@RequestBody TrainingCalendar trainingCalendar){
        try {

            return ResponseEntity.ok().body(this.trainingCalendarService.createTrainingCalendar(trainingCalendar));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Training Calendar already exists");
        }
    }

    @GetMapping("/allTrainingCalendar")
    private ResponseEntity<List<TrainingCalendar>> getAllTrainingCalendar(){
        return ResponseEntity.ok().body(this.trainingCalendarService.getTrainingCalendar());
    }
}
