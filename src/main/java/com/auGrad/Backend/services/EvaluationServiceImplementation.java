package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Evaluation;
import com.auGrad.Backend.repository.EvaluationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImplementation implements EvaluationService{
    @Autowired
    private EvaluationRepo evaluationRepo;
    @Override
    public Evaluation createEvaluation(Evaluation evaluation) {
        Evaluation evaluationAdded = evaluationRepo.save(evaluation);
        return evaluationAdded;
    }

    @Override
    public List<Evaluation> getEvaluation() {
        return this.evaluationRepo.findAll();
    }
}
