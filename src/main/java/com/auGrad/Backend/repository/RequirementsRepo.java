package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementsRepo extends JpaRepository<Requirements,Integer> {
    List<Requirements> findByBatchId(int batchId);
}
