package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.StatusCode;

import java.util.List;

public interface BatchService {

    //Batch createBatch(Batch batch);
    String createBatch(Batch batch);
    List<Batch> getBatches();
}