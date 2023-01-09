package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;

import com.auGrad.Backend.repository.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BatchServiceImplementation implements BatchService {
    @Autowired
    private BatchRepo batchrepo;
    public Batch createBatch(Batch batch){
       Batch batchAdded =  this.batchrepo.save(batch);
       return batchAdded;

    }

    @Override
    public  List<Batch> getBatches(){

        return this.batchrepo.findAll();
    }

}
