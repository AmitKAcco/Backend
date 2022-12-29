package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.services.BlockedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
