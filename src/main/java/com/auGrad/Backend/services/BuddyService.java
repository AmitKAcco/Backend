package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Buddy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuddyService {

    Buddy createBuddy(Buddy buddy);

    List<Buddy> getBuddy();

    Buddy getBuddyByBatchId(int batchId);
}
