package com.auGrad.Backend.services;


import com.auGrad.Backend.model.Requirements;
import com.auGrad.Backend.repository.RequirementsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementsServiceImplementation implements RequirementsService{
    @Autowired
    private RequirementsRepo requirementsRepo;

    @Autowired
    private Requirements requirementsAdded;
    @Override
    public Requirements createRequirements(Requirements requirements){
        Requirements requirementsAdded=  requirementsRepo.save(requirements);

        return requirementsAdded;

    }

    @Override
    public List<Requirements> getRequirements(){

        return this.requirementsRepo.findAll();
    }
}
