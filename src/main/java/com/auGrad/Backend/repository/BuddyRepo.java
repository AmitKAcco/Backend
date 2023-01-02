package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Buddy;
import com.auGrad.Backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuddyRepo extends JpaRepository<Buddy,Integer> {
    @Query("Select b  from Buddy b where b.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    Buddy findByBatchId(int batchId);
}
