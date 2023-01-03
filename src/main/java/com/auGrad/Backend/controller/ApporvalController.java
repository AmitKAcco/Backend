package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Approval;
import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.services.ApprovalServiceImplementation;
import com.auGrad.Backend.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/approval/{batchId}")
    private Approval getApproval(@PathVariable Integer batchId){
        return this.approvalServiceImplementation.getApproval(batchId);
    }

    @GetMapping("/allApproval")
    private List<Approval> getAllApproval(){
        return  this.approvalServiceImplementation.getALlApproval();
    }

}
