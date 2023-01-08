package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.MockInterview;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.MockInterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MockInterviewServiceImplementation implements MockInterviewService {

    @Autowired
    private MockInterviewRepo mockInterviewRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    public MockInterview createMockInterview(MockInterview mockInterview) {
        MockInterview mockInterviewAdded = mockInterviewRepo.save(mockInterview);
        Optional<Employee> obj = employeeRepo.findById(mockInterview.getEmpId());
     //   Optional<Batch> objBatch = batchRepo.findById(mockInterview.getBatchId());

        if(obj.isPresent()){
            Employee e = obj.get();
            mockInterviewAdded.setEmpName(e.getEmployeeName());
            mockInterviewAdded.setBatchName(e.getBatchName());
            mockInterviewAdded.setBatchId(e.getBatchId());
        }
//        if(objBatch.isPresent()){
//            Batch b = objBatch.get();
//            mockInterviewAdded.setBatchName(b.getBatchName());
//        }
        mockInterviewRepo.save(mockInterviewAdded);
        return mockInterviewAdded;
    }

    @Override
    public List<MockInterview> getMockInterview() {
        return this.mockInterviewRepo.findAll();
    }

    @Override
    public List<MockInterview> getMockInterviewByBatchId(int batchId){

        return this.mockInterviewRepo.findByBatchId(batchId);
    }
}
