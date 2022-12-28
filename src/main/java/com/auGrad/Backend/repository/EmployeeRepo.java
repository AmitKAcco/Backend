package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
   // String findNameById(int empIdGrad);
    //String findNameById(int empIdMentor);
    //String findNameByIdGrad(int empIdGrad);
    //  Object findAllById();
}
