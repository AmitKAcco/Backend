package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Interview;
import com.auGrad.Backend.model.Requirements;
import com.auGrad.Backend.model.Selected;
import com.auGrad.Backend.repository.SelectedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SelectedServiceImplementation implements SelectedService{
    @Autowired
    private SelectedRepo selectedRepo;

    @Override
    public List<Selected> getSelectedGrads(){
        return this.selectedRepo.findAll();
    }

    @Override
    public boolean isGradSelected(int empId, int jobId){
        boolean isSelected = this.selectedRepo.findByEmpIdAndJobId(empId,jobId).size() == 0 ? false : true;
        return isSelected;
    }

    @Override
    public Selected addSelectedGrad(Selected gradSelected){
        Selected gradAdded=  selectedRepo.save(gradSelected);
        return gradAdded;
    }

    @Override
    public int deleteSelectedGrad(Selected selectedGrad){
        selectedRepo.deleteByEmpIdAndJobId(selectedGrad.getEmpId(),selectedGrad.getJobId());
        return 200;
    }

    @Override
    public Integer getEmployeesCountByBatchId(int batchId) {
        return this.selectedRepo.getCountByBatchId(batchId);
    }

}
