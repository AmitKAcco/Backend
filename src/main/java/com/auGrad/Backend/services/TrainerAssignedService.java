package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Requirements;
import com.auGrad.Backend.model.TrainerAssigned;

import java.util.List;

public interface TrainerAssignedService {
    TrainerAssigned createTrainerAssigned(TrainerAssigned trainerAssigned);



    List<TrainerAssigned> getTrainerAssigned();
}
