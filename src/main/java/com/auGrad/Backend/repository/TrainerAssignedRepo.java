package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.TrainerAssigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerAssignedRepo extends JpaRepository<TrainerAssigned,Integer> {
    List<TrainerAssigned> findByBatchId(int batchId);
}