package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Evaluation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EvaluationService {

    Evaluation createEvaluation(Evaluation evaluation);

    List<Evaluation> getEvaluation();

    Evaluation getEvaluationByBatchId(int batchId);
}
