package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Feedback;
import com.auGrad.Backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
