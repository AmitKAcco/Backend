package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Employee;

import java.util.List;

public interface EmployeeService{

    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();
}
