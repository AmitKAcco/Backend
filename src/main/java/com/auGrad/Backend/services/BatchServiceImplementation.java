package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;

import com.auGrad.Backend.model.StatusCode;
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
//    public StatusCode createBatch(Batch batch){
//        Optional<Batch> obj = this.batchrepo.findByBatchName(batch.getBatchName());
//
//        if(obj.isPresent())
//        {
//            return (new StatusCode("Batch already exist",false));
//        }
//
//
//        Batch batchAdded =  this.batchrepo.save(batch);
//
//
//       //return batchAdded;
//        return (new StatusCode("Batch Created",true));
//
//    }
    public String createBatch(Batch batch){
        Optional<Batch> obj = this.batchrepo.findByBatchName(batch.getBatchName());

        if(obj.isPresent())
        {
            return "batch already exists";
        }

        this.batchrepo.save(batch);

        //return batchAdded;
        return "Batch Created";

    }
    @Override
    public  List<Batch> getBatches(){

        return this.batchrepo.findAll();
    }

}
