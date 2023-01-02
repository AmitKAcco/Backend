package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Buddy;
import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.services.BuddyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuddyController {

    @Autowired
    private BuddyService buddyService;

    @PostMapping("/addBuddy")
    private ResponseEntity<Buddy> saveBuddy(@RequestBody Buddy buddy){
        try{
            return ResponseEntity.ok().body(this.buddyService.createBuddy(buddy));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Buddy Already Exist");
        }
    }
    @GetMapping("/allBuddy")
    private ResponseEntity<List<Buddy>> getAllBuddy(){

        return ResponseEntity.ok().body(this.buddyService.getBuddy());
    }

    @GetMapping("/buddyByBatchId/{batchId}")
    private ResponseEntity<Buddy> getBuddyByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.buddyService.getBuddyByBatchId(batchId));
    }
}
