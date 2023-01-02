package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    @Query("Select e  from Employee e where e.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    @Query("Select count(batchId) from Employee e where e.batchId=?1")
    Integer getCountByBatchId(int batchId);
    // String findNameById(int empIdGrad);
    //String findNameById(int empIdMentor);
    //String findNameByIdGrad(int empIdGrad);
    //  Object findAllById();
}
