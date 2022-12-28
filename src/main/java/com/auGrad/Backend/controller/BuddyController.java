package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Buddy;
import com.auGrad.Backend.services.BuddyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
