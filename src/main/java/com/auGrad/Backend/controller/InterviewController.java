package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Interview;
import com.auGrad.Backend.services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/interviewByBatchId/{batchId}")
    private ResponseEntity<Interview> getInterviewByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.interviewService.getInterviewByBatchId(batchId));
    }

    @PostMapping("/aa")
    private  ResponseEntity<List<Integer>> aa(@RequestBody Blocked checkInterviewScheduled){
        return ResponseEntity.ok().body(this.interviewService.getEmpScheduledInterview(checkInterviewScheduled));
    }

    @PostMapping("/gradSelected")
    private ResponseEntity<Integer> updateInterviewForSelected(@RequestBody() Interview interviewDetails){
//        log.debug("inside update interview For Interview selected ");
        return ResponseEntity.ok().body(this.interviewService.updateInterviewForSelectedFunc(interviewDetails));
    }

}
