package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementsRepo extends JpaRepository<Requirements,Integer> {
    List<Requirements> findByBatchId(int batchId);
    @Query("Select count(batchId) from Requirements e where e.batchId=?1")
    Integer getCountByBatchId(int batchId);

}
