package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BatchController {
    @Autowired
    private BatchService batchService;

    @PostMapping("/addBatch")
    private ResponseEntity<Batch> saveBatch(@RequestBody Batch batch){
        try {

            return ResponseEntity.ok().body(this.batchService.createBatch(batch));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Batch already exists");
        }
    }

    @GetMapping("/allBatches")
    private ResponseEntity<List<Batch>> getAllEmployees(){
        return ResponseEntity.ok().body(this.batchService.getBatches());
    }

    @GetMapping("/checkIfBatchAlreadyExists/{batchName}")
    private ResponseEntity<Boolean> checkIfBatchAlreadyExists(@PathVariable String batchName){
        return ResponseEntity.ok().body(this.batchService.checkIfBatchAlreadyExists(batchName));
    }


}
