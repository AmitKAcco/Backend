package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private BatchRepo batchRepo;
    @Autowired
    private FeedbackRepo feedbackRepo;
    @Autowired
    private Batch batchAdded;

    @Override
    public Employee createEmployee(Employee employee){
        Employee employeeAdded = employeeRepo.save(employee);

        return employeeAdded;
    }
    @Override
    public List<Employee> getEmployees(){

        return this.employeeRepo.findAll();
    }

    @Override
    public List<Employee> getEmployeesByBatchId(int batchId){

        return this.employeeRepo.findAllByBatchId(batchId);
    }

    @Override
    public Integer getEmployeesCountByBatchId(int batchId){

        return this.employeeRepo.getCountByBatchId(batchId);
    }

//    @Override
//    public List<Employee> getEmployessByBatchName(String batchName) {
//        return this.employeeRepo.getByBatchName(batchName);
//    }

}
