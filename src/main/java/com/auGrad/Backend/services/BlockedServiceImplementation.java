package com.auGrad.Backend.services;

import com.auGrad.Backend.model.*;
import com.auGrad.Backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class BlockedServiceImplementation implements BlockedService{

    @Autowired
    private BlockedRepo blockedRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private SelectedRepo selectedRepo;

    @Autowired
    private Batch batch;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    public Blocked createBlocked(Blocked blocked) {
        Blocked blockedAdded = blockedRepo.save(blocked);
        Optional<Employee> employeeObj = employeeRepo.findById(blocked.getEmpId());
        Optional<Batch> obj = batchRepo.findByBatchName(blocked.getBatchName());
//   Optional<Batch> objBatch = batchRepo.findById(mockInterview.getBatchId());

        if(obj.isPresent()) {
            Batch b = obj.get();
            blockedAdded.setBatchId(b.getBatchId());
        }
        blockedRepo.save(blockedAdded);
        if(employeeObj.isPresent()){
            Employee e = employeeObj.get();
            blockedAdded.setEmpName(e.getEmployeeName());
        }
        Optional<Job> jobObj = jobRepo.findById(blocked.getJobId());
        if(jobObj.isPresent()){
            Job j = jobObj.get();
            blockedAdded.setClient(j.getClient());
        }
        blockedRepo.save(blockedAdded);

        blockedRepo.save(blockedAdded);
        return blockedAdded;
    }

    @Override
    public void updateBlockedForInterviewScheduledfunc(Blocked updateBlocked){

        blockedRepo.updateBlockedForInterviewScheduled(updateBlocked.getEmpId(),updateBlocked.getJobId());
    }

    @Override
    public void updateBlockedForSelectedfunc(Blocked updateBlocked){

        blockedRepo.updateBlockedForSelected(updateBlocked.getEmpId(),updateBlocked.getJobId());

    }



    @Override
    public List<Blocked> getBlocked() {
        return this.blockedRepo.findAll();
    }

    @Override
    public Blocked getBlockedByBatchId(int batchId) {
        return this.blockedRepo.findByBatchId(batchId);
    }

    @Override
    public List<Integer> getEligibleGrads(Blocked checkEligibility){

        List<Integer> employees = this.employeeRepo.findAllEmpIdByBatchId(checkEligibility.getBatchId());
        List<Integer> blockedEmployees = this.blockedRepo.findEmpIdByJobId(checkEligibility.getJobId());
        List<Integer> selectedEmployees = this.selectedRepo.findAllEmpId();

        employees.removeAll(blockedEmployees);
        employees.removeAll(selectedEmployees);

        return employees;

    }
}
