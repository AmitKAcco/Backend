package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Evaluation;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.EvaluationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EvaluationServiceImplementation implements EvaluationService{
    @Autowired
    private EvaluationRepo evaluationRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Batch batch;

    @Autowired
    private BatchRepo batchRepo;
    @Override
    public Evaluation createEvaluation(Evaluation evaluation) {
        Evaluation evaluationAdded = evaluationRepo.save(evaluation);
        Optional<Employee> employeeOBj = employeeRepo.findById(evaluation.getEmpId());
        Optional<Batch> obj3 = batchRepo.findByBatchName(evaluation.getBatchName());


        if(obj3.isPresent()){
            Batch b = obj3.get();
            evaluationAdded.setBatchId(b.getBatchId());

            // interviewAdded.setBatchId(e.getBatchN());
        }
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
