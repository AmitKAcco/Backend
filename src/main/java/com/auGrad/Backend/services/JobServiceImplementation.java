package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImplementation implements JobService{
    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private Job jobAdded;
    @Override
    public Job createJob(Job job){
        Job jobAdded =  jobRepo.save(job);

        return jobAdded;

    }

    @Override
    public List<Job> getJob(){

        return this.jobRepo.findAll();
    }
}
