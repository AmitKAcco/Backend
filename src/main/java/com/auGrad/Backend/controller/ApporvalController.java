package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Approval;
import com.auGrad.Backend.services.ApprovalServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApporvalController {
    @Autowired
    private ApprovalServiceImplementation approvalServiceImplementation;

    @PostMapping("/addApproval")
    private ResponseEntity<Approval> saveBatch(@RequestBody Approval obj){
        try {

            return ResponseEntity.ok().body(this.approvalServiceImplementation.createApproval(obj));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Batch already exists");
        }
    }
    @GetMapping("/approval/{batchName}")
    private Optional<Approval> getApproval(@PathVariable String batchName){
        return this.approvalServiceImplementation.getApproval(batchName);
    }

    @GetMapping("/allApproval")
    private List<Approval> getAllApproval(){
        return  this.approvalServiceImplementation.getALlApproval();
    }

}
