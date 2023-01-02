package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepo extends JpaRepository<Dashboard,Integer> {

    @Query("Select d  from Dashboard d where d.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    Dashboard findByBatchId(int batchId);
}
