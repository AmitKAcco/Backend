package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Evaluation;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.EvaluationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationServiceImplementation implements EvaluationService{
    @Autowired
    private EvaluationRepo evaluationRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Evaluation createEvaluation(Evaluation evaluation) {
        Evaluation evaluationAdded = evaluationRepo.save(evaluation);
        Optional<Employee> employeeOBj = employeeRepo.findById(evaluation.getEmpId());
        if(employeeOBj.isPresent()){
            Employee e = employeeOBj.get();
            evaluationAdded.setEmpName(e.getEmployeeName());
        }
        evaluationRepo.save(evaluationAdded);
        return evaluationAdded;
    }

    @Override
    public List<Evaluation> getEvaluation() {
        return this.evaluationRepo.findAll();
    }

    @Override
    public Evaluation getEvaluationByBatchId(int batchId) {
        return this.evaluationRepo.findByBatchId(batchId);
    }
}
