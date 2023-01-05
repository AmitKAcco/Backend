package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.repository.BlockedRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlockedServiceImplementation implements BlockedService{

    @Autowired
    private BlockedRepo blockedRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private JobRepo jobRepo;

    @Override
    public Blocked createBlocked(Blocked blocked) {
        Blocked blockedAdded = blockedRepo.save(blocked);
        Optional<Employee> employeeObj = employeeRepo.findById(blocked.getEmpId());
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

}
