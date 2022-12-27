package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    private ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        try {

            return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Employee already exists");
        }
    }

    @GetMapping("/allEmployees")
    private ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(this.employeeService.getEmployees());
    }


}
