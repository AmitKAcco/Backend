package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;

import com.auGrad.Backend.repository.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BatchServiceImplementation implements BatchService {
    @Autowired
    private BatchRepo batchRepo;
    public Batch createBatch(Batch batch){
       Batch batchAdded =  this.batchRepo.save(batch);
       return batchAdded;

    }

    @Override
    public  List<Batch> getBatches(){

        return this.batchRepo.findAll();
    }
    @Override
    public boolean checkIfBatchAlreadyExists(String batchName){
        Optional<Batch> findBatch = this.batchRepo.findByBatchName(batchName);
        return findBatch.isPresent();
    }


}
