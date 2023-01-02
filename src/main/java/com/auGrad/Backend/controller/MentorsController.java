package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Mentors;

import com.auGrad.Backend.model.MockInterview;
import com.auGrad.Backend.services.MentorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorsController {
    @Autowired
    private MentorsService mentorsService;

    @PostMapping("/addMentors")
    private ResponseEntity<Mentors> saveMentors(@RequestBody Mentors mentors){
        try {

            return ResponseEntity.ok().body(this.mentorsService.createMentor(mentors));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Mentor already exists");
        }
    }

    @GetMapping("/allMentors")
    private ResponseEntity<List<Mentors>> getAllMentors(){
        return ResponseEntity.ok().body(this.mentorsService.getMentors());
    }
    @GetMapping("/MentorsByBatchId/{batchId}")
    private ResponseEntity<List<Mentors>> getMentorsByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.mentorsService.getMentorsByBatchId(batchId));
    }
}
