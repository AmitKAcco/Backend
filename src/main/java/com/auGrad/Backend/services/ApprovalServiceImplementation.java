package com.auGrad.Backend.services;


import com.auGrad.Backend.model.Approval;
import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.repository.ApprovalRepo;
import com.auGrad.Backend.repository.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ApprovalServiceImplementation implements AppovalService{
    @Autowired
    private ApprovalRepo approvalRepo;

    @Autowired
    private BatchRepo batchRepo;


    @Override
    public Approval createApproval(Approval obj) {
        Optional<Approval> findApproval= this.approvalRepo.findByBatchName(obj.getBatchName());
        Optional<Batch> findBatch = this.batchRepo.findByBatchName(obj.getBatchName());
        if(findApproval.isPresent()){
            findBatch.ifPresent(batch -> findApproval.get().setBatchId(batch.getBatchId()));
            findApproval.get().setBatchId(obj.getBatchId());
            if(obj.getTechCalendar() == null){
                findApproval.get().setTechCurriculum(obj.getTechCurriculum());
            } else {
                findApproval.get().setTechCalendar(obj.getTechCalendar());
            }
//            this.approvalRepo.deleteById(findApproval.get().getApprovalId());
            return this.approvalRepo.save(findApproval.get());
        } else {
            return this.approvalRepo.save(obj);
        }
    }
//        Optional<Batch> findBatch = this.batchRepo.findByBatchName(obj.getBatchName());
//        if(findApproval.isPresent()){
//            Approval approve = new Approval();
//            findBatch.ifPresent(batch -> approve.setBatchId(batch.getBatchId()));
//            approve.setBatchName(obj.getBatchName());
//
//            if(obj.getTechCalendar() == 1 && obj.getTechCurriculum() == -1){
//                approve.setTechCalendar(1);
//                approve.setTechCurriculum(findApproval.get().getTechCurriculum());
//            }
//            if(obj.getTechCalendar() == -1 && obj.getTechCurriculum() == 1){
//                approve.setTechCalendar(findApproval.get().);
//            }
//            if(obj.getTechCalendar() == -1){
//                approve.setTechCalendar(findApproval.get().getTechCalendar());
//            }
//            if(obj.getTechCurriculum() == -1){
//                approve.setTechCurriculum(-1);
//            }
//            if(obj.getTechCurriculum() == 0){
//                approve.setTechCurriculum(0);
//            }

//            this.approvalRepo.deleteById(findApproval.get().getApprovalId());
//            System.out.print("---------------------------------" +
//                    "------------------------------------------------" +
//                    "------------------------------------------------------" +
//                    "-------------------------------------------------------" +
//                    "" +
//                    "" +
//                    "-" +
//                    "-------------------------------------" +
//                    "----------");
////            System.out.print(approve);
//            System.out.print(approve.getApprovalId()+ " "+ approve.getApprovalId());
//            return this.approvalRepo.save(approve);
//        } else {
//            findBatch.ifPresent(batch -> obj.setBatchId(batch.getBatchId()));
//            return this.approvalRepo.save(obj);
//        }
//    }

    @Override
    public Optional<Approval> getApproval(String batchName) {
        return this.approvalRepo.findByBatchName(batchName);
    }

    @Override
    public List<Approval> getALlApproval() {
        return this.approvalRepo.findAll();
    }
}

