package com.auGrad.Backend.services.Impl;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImplementation {
    @Autowired
    private BatchRepo batchrepo;
    public void createBatch(Batch batch){
        batchrepo.save(batch);


    }
}
