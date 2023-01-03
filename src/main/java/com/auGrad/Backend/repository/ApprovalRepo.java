package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Approval;
import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.Blocked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApprovalRepo extends JpaRepository<Approval,Integer> {

    Approval findByBatchId(Integer batchId);

//    Approval findByBatchId(int id);
}
