package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService{

    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();
}
