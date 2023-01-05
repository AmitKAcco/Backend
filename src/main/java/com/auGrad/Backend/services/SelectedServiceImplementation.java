package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Requirements;
import com.auGrad.Backend.model.Selected;
import com.auGrad.Backend.repository.SelectedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SelectedServiceImplementation implements SelectedService{
    @Autowired
    private SelectedRepo selectedRepo;

    @Override
    public List<Selected> getSelectedGrads(){
        return this.selectedRepo.findAll();
    }

    @Override
    public List<Selected> isGradSelected(int empId){
        return this.selectedRepo.findByEmpId(empId);
    }

    @Override
    public Selected addSelectedGrad(Selected gradSelected){
        Selected gradAdded=  selectedRepo.save(gradSelected);
        return gradAdded;
    }

}
