package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.CheckBlocked;
import com.auGrad.Backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CheckBlockedRepo extends JpaRepository<CheckBlocked,Integer> {

    @Query("Select c  from CheckBlocked c where c.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    CheckBlocked findByBatchId(int batchId);
}
