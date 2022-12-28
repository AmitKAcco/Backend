package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Buddy;
import com.auGrad.Backend.repository.BuddyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BuddyServiceImplementation implements BuddyService{

    @Autowired
    private BuddyRepo buddyRepo;

    @Override
    public Buddy createBuddy(Buddy buddy) {
        Buddy buddyAdded = buddyRepo.save(buddy);
        return buddyAdded;
    }

    @Override
    public List<Buddy> getBuddy()
    {
        return this.buddyRepo.findAll();
    }
}
