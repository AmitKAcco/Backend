package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepo extends JpaRepository<Batch,Integer> {


    Optional<Batch> findByBatchName(String batchName);
}
