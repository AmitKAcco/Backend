package com.auGrad.Backend.services;


import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.model.Mentors;
import com.auGrad.Backend.model.Requirements;
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
