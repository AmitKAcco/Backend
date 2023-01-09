package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplementation implements JobService{
    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private Job jobAdded;

    @Autowired
    private Batch batch;

    @Autowired
    private BatchRepo batchRepo;
    @Override
    public Job createJob(Job job){
        Job jobAdded =  jobRepo.save(job);
        Optional<Batch> obj3 = batchRepo.findByBatchName(job.getBatchName());


        if(obj3.isPresent()){
            Batch b = obj3.get();
            jobAdded.setBatchId(b.getBatchId());

            // interviewAdded.setBatchId(e.getBatchN());
        }
     jobRepo.save(jobAdded);
        return jobAdded;

    }

    @Override
    public List<Job> getJob(){

        return this.jobRepo.findAll();
    }

    @Override
    public Job getJobByBatchId(int batchId) {
        return this.jobRepo.findByBatchId(batchId);
    }
}
