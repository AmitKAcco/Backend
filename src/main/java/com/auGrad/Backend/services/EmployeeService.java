package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService{

    String createEmployee(Employee employee);

    List<Employee> getEmployees();

    //List<Employee> getEmployeesByBatchId();

    List<Employee> getEmployeesByBatchId(int batchId);

    Integer getEmployeesCountByBatchId(int batchId);
//    List<Employee> getEmployessByBatchName(String batchName);
}
