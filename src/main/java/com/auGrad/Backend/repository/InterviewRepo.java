package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepo extends JpaRepository<Interview,Integer> {

    @Query("Select i  from Interview i where i.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    Interview findByBatchId(int batchId);
}
