package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Feedback;
import com.auGrad.Backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/addFeedback")
    private ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback){
        try{
            return ResponseEntity.ok().body(this.feedbackService.createFeedback(feedback));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Feedback Already Exist");
        }
    }
    @GetMapping("/allFeedback")
    private ResponseEntity<List<Feedback>> getAllFeedback(){
        return ResponseEntity.ok().body(this.feedbackService.getFeedback());
    }
    @GetMapping("/feedbackByBatchId/{batchId}")
    private ResponseEntity<Feedback> getFeedbackByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.feedbackService.getFeedbackByBatchId(batchId));
    }

    @GetMapping("/feedbackByEmpId/{empId}")
    private ResponseEntity<List<Feedback>> getFeedbackByEmpID(@PathVariable int empId)
    {
        return ResponseEntity.ok().body(this.feedbackService.getFeedbackByEmpId(empId));
    }
}
