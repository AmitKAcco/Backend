package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.TrainerAssigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerAssignedRepo extends JpaRepository<TrainerAssigned,Integer> {
}