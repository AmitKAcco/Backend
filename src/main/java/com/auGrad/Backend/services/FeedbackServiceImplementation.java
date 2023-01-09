package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Feedback;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImplementation implements FeedbackService{
    @Autowired
    private FeedbackRepo feedbackRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Batch batch;

    @Autowired
    private BatchRepo batchRepo;
    @Override
    public Feedback createFeedback(Feedback feedback) {
        Feedback feedbackAdded = feedbackRepo.save(feedback);
        Optional<Employee> employeeobj = employeeRepo.findById(feedback.getEmpId());

        if(employeeobj.isPresent()){
            Employee e = employeeobj.get();
            feedbackAdded.setEmpName(e.getEmployeeName());
        }
        Optional<Batch> obj3 = batchRepo.findByBatchId(feedback.getBatchId());


        if(obj3.isPresent()){
            Batch b = obj3.get();
            feedbackAdded.setBatchName(b.getBatchName());

            // interviewAdded.setBatchId(e.getBatchN());
        }

        feedbackRepo.save(feedbackAdded);
        return feedbackAdded;
    }

    @Override
    public List<Feedback> getFeedback() {
        return this.feedbackRepo.findAll();
    }


    @Override
    public Feedback getFeedbackByBatchId(int batchId) {
        return this.feedbackRepo.findByBatchId(batchId);
    }

    @Override
    public List<Feedback> getFeedbackByEmpId(int empId) {
        return this.feedbackRepo.findByEmpId(empId);
    }

}
