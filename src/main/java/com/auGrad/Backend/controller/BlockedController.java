package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.services.BlockedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
//@CrossOrigin("http://localhost:4200")
public class BlockedController {

    @Autowired
    private BlockedService blockedService;

    @PostMapping("/addBlocked")
    private ResponseEntity<Blocked> saveBatch(@RequestBody Blocked blocked){
        try{
            return ResponseEntity.ok().body(this.blockedService.createBlocked(blocked));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Blocked Already Exist");
        }
    }
    @GetMapping("/allBlocked")
    private ResponseEntity<List<Blocked>> getAllBlocked(){
        return ResponseEntity.ok().body(this.blockedService.getBlocked());
    }

    @PostMapping("/getEligibleGrads")
    private ResponseEntity<List<Integer>> eligibleGrads(@RequestBody Blocked checkEligibility){
        return ResponseEntity.ok().body(this.blockedService.getEligibleGrads(checkEligibility));
    }
    @GetMapping("/blockedByBatchId/{batchId}")
    private ResponseEntity<Blocked> getBlockedByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.blockedService.getBlockedByBatchId(batchId));
    }

    @PostMapping("/interviewScheduled")
    private ResponseEntity<Integer> updateBlockedForInterviewScheduled(@RequestBody() Blocked interviewScheduled){
        log.debug("inside update Blocked For Interview Scheduled ");
        return ResponseEntity.ok().body(this.blockedService.updateBlockedForInterviewScheduledFunc(interviewScheduled));
    }

}
