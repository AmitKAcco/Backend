package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Evaluation;
import com.auGrad.Backend.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/addEvaluation")
    private ResponseEntity<Evaluation> saveEvaluation(@RequestBody Evaluation evaluation){
        try {
            return ResponseEntity.ok().body(this.evaluationService.createEvaluation(evaluation));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Evaluation Already Exist");
        }
    }
    @GetMapping("/allEvaluations")
    private ResponseEntity<List<Evaluation>> getAllEvaluation(){
        return ResponseEntity.ok().body(this.evaluationService.getEvaluation());
    }
    @GetMapping("/evaluationByBatchId/{batchId}")
    private ResponseEntity<Evaluation> getEvaluationByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.evaluationService.getEvaluationByBatchId(batchId));
    }
}
