package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Interview;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.model.Selected;

import java.util.List;

public interface SelectedService {

    List<Selected> getSelectedGrads();

    boolean isGradSelected(int empId, int jobId);

    Selected addSelectedGrad(Selected gradSelected);

    int deleteSelectedGrad(Selected selectedGrad);

    Integer getEmployeesCountByBatchId(int batchId);
}
