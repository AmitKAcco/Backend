package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;

import java.util.List;

public interface BatchService {


  

    Boolean createBatch(Batch batch);
   

    List<Batch> getBatches();

    boolean checkIfBatchAlreadyExists(String batchName);
}