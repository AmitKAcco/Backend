package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.repository.ApprovalRepo;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
    public String createEmployee(Employee employee){

        System.out.println("mobbbss");
        System.out.println(employee.getMobileNumber());
        System.out.println("emaillss");
        System.out.println(employee.getEmail());
        Optional<Employee> objMob = this.employeeRepo.findByMobileNumber(employee.getMobileNumber());
        if(objMob.isPresent())
        {
            return("Mobile already exists");
        }
        Optional<Employee> objEmail = this.employeeRepo.findByEmail(employee.getEmail());
        if(objEmail.isPresent())
        {
            return("Email already exists");
        }

//        if(obj3.isPresent())
//        {
//            return (true);
//        }


        Employee employeeAdded = employeeRepo.save(employee);
        Optional<Batch> obj3 = batchRepo.findByBatchName(employee.getBatchName());
        if(obj3.isPresent()){
            Batch b = obj3.get();
            employeeAdded.setBatchId(b.getBatchId());
            // interviewAdded.setBatchId(e.getBatchN());
        }
        employeeRepo.save(employeeAdded);
        return ("Graduate Added");
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
