package com.auGrad.Backend.services;


import com.auGrad.Backend.model.*;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.JobRepo;
import com.auGrad.Backend.repository.RequirementsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequirementsServiceImplementation implements RequirementsService{
    @Autowired
    private RequirementsRepo requirementsRepo;

    @Autowired
    private Requirements requirementsAdded;

    @Autowired
    private  Job job;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private Batch batch;
    @Autowired
    private BatchRepo batchRepo;
    @Override
    public Requirements createRequirements(Requirements requirements){
        Requirements requirementsAdded=  requirementsRepo.save(requirements);


        Optional<Job> jobobj = jobRepo.findById(requirements.getJobId());
        if(jobobj.isPresent()){
            Job j = jobobj.get();
            //interviewAdded.setGradName(j.getClient());
            requirementsAdded.setClient(j.getClient());
            requirementsAdded.setVertical(j.getVertical());


        }
        Optional<Batch> obj3 = batchRepo.findByBatchName(job.getBatchName());


        if(obj3.isPresent()){
            Batch b = obj3.get();
            requirementsAdded.setBatchId(b.getBatchId());

            // interviewAdded.setBatchId(e.getBatchN());
        }
        requirementsRepo.save(requirementsAdded);
        return requirementsAdded;

    }

    @Override
    public List<Requirements> getRequirements(){

        return this.requirementsRepo.findAll();
    }

    @Override
    public List<Requirements> getRequirementsByBatchId(int batchId){

        return this.requirementsRepo.findByBatchId(batchId);
    }

    @Override
    public Integer getCountbyBatchId(int batchId) {
        return this.requirementsRepo.getCountByBatchId(batchId);
    }
}
