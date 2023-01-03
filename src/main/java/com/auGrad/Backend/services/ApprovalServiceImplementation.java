package com.auGrad.Backend.services;


import com.auGrad.Backend.model.Approval;
import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.repository.ApprovalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ApprovalServiceImplementation implements AppovalService{
    @Autowired
    private ApprovalRepo approvalRepo;


    @Override
    public Approval createApproval(Approval obj) {
        Optional<Approval> findApproval= Optional.ofNullable(this.approvalRepo.findByBatchId(obj.getBatchId()));
        if(findApproval.isPresent()){
            Approval approve = new Approval();
            approve.setBatchId(obj.getBatchId());
            approve.setTechCalendar(obj.isTechCurriculum());
            approve.setTechCurriculum(obj.isTechCalendar());
            this.approvalRepo.deleteById(findApproval.get().getApprovalId());
            return this.approvalRepo.save(approve);
        } else {
            return this.approvalRepo.save(obj);
        }
    }

    @Override
    public Approval getApproval(Integer batchId) {
        return this.approvalRepo.findByBatchId(batchId);
    }

    @Override
    public List<Approval> getALlApproval() {
        return this.approvalRepo.findAll();
    }
}

