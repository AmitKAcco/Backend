package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.model.Selected;

import java.util.List;

public interface SelectedService {

    List<Selected> getSelectedGrads();

    List<Selected> isGradSelected(int empId);

    Selected addSelectedGrad(Selected gradSelected);

}
