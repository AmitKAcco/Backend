package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.model.Requirements;

import java.util.List;

public interface RequirementsService {


    Requirements createRequirements(Requirements requirements);

    List<Requirements> getRequirements();

    List<Requirements> getRequirementsByBatchId(int batchId);
}
