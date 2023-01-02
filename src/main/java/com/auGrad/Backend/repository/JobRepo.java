package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job,Integer> {
    @Query("Select e  from Job e where e.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    Job findByBatchId(int batchId);
}
