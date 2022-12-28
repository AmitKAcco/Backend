package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Interview;
import com.auGrad.Backend.services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @PostMapping("/addInterview")
    private ResponseEntity<Interview> saveInterview(@RequestBody Interview interview)
    {
        try{
            return  ResponseEntity.ok().body(this.interviewService.createInterview(interview));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Interview Already Exist");
        }

    }
    @GetMapping("/allInterview")
    private  ResponseEntity<List<Interview>> getAllInterview(){
        return ResponseEntity.ok().body(this.interviewService.getInterview());
    }
}
