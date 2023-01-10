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
    private BatchRepo batchrepo;
    public Boolean createBatch(Batch batch){
        Optional<Batch> obj = this.batchrepo.findByBatchName(batch.getBatchName());

        if(obj.isPresent())
        {
            return (true);
        }


        Batch batchAdded =  this.batchrepo.save(batch);


       //return batchAdded;
        return (false);

    }

    @Override
    public  List<Batch> getBatches(){

        return this.batchrepo.findAll();
    }

}
