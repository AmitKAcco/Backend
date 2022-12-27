package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.repository.BlockedRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlockedServiceImplementation implements BlockedService{

    @Autowired
    private BlockedRepo blockedRepo;

    @Override
    public Blocked createBlocked(Blocked blocked) {
        Blocked blockedAdded = blockedRepo.save(blocked);
        return blockedAdded;
    }

    @Override
    public List<Blocked> getBlocked() {
        return this.blockedRepo.findAll();
    }
}
