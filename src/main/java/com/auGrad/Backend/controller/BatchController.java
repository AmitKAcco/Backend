package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
