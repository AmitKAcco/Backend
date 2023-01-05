package com.auGrad.Backend.services;

import com.auGrad.Backend.model.*;
import com.auGrad.Backend.repository.*;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewServiceImplementation implements InterviewService{
    @Autowired
    private InterviewRepo interviewRepo;
    @Autowired
    private BlockedRepo blockedRepo;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private Job job;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Blocked b;

    @Autowired
    private Blocked b1;

    @Autowired
    private CheckBlocked checkBlocked;

    @Autowired
    private CheckBlockedRepo checkBlockedRepo;

    @Autowired
    private Interview interviewAdded;
    @Override
    public Interview createInterview(Interview interview) {
        Interview interviewAdded = interviewRepo.save(interview);

//        Interview i = new Interview();

//        i.setBatchId(interview.getBatchId());
//        i.setEmpId(interview.getEmpId());
//        i.setJobId(interview.getJobId());
        Blocked obj = new Blocked();
        System.out.println(interview.getJobId() + " " + interview.getEmpId());
        obj.setBatchId(interview.getBatchId());
        obj.setJobId(interview.getJobId());
        obj.setEmpId(interview.getEmpId());

        CheckBlocked obj1 = new CheckBlocked();
        System.out.println(interview.getJobId() + " " + interview.getEmpId());
        obj1.setBatchId(interview.getBatchId());
        obj1.setJobId(interview.getJobId());
        obj1.setEmpId(interview.getEmpId());



        Optional<Employee> employeeobj1 = employeeRepo.findById(interview.getEmpId());
        if(employeeobj1.isPresent()){
            Employee e=employeeobj1.get();
            interviewAdded.setGradName(e.getEmployeeName());
            obj.setEmpName(e.getEmployeeName());
            obj1.setEmpName(e.getEmployeeName());

        }
        Optional<Job> jobobj = jobRepo.findById(interview.getJobId());
        if(jobobj.isPresent()){
            Job j = jobobj.get();
            //interviewAdded.setGradName(j.getClient());

            obj.setClient(j.getClient());
            obj1.setClient(j.getClient());


        }
        obj1.setBlockStatus(true);
        blockedRepo.save(obj);
        checkBlockedRepo.save(obj1);

        interviewRepo.save(interviewAdded);


//        Optional<Blocked> blockedobj = blockedRepo.findById(interview.getEmpId());
//        //Blocked blocked = new Blocked();
//            b = blockedobj.get();
//            b1.setJobId(b.getJobId());
//            b1.setEmpId(b.getEmpId());
//            b1.setBatchId(b.getBatchId());
//

//        blockedRepo.save(b1);
        return interviewAdded;
    }

    @Override
    public List<Interview> getInterview() {
        return this.interviewRepo.findAll();
    }

    @Override
    public Interview getInterviewByBatchId(int batchId) {
        return this.interviewRepo.findByBatchId(batchId);
    }

//    @Override
//    public List<Employee> getEligibleForInterview() {
////        return this.interviewRepo.findAll();
//        return
//    }
@Override
public List<Integer> getEmpScheduledInterview(Blocked checkInterviewScheduled) {
        return this.interviewRepo.findEmpIdIfInterviewScheduled(checkInterviewScheduled.getJobId());
}

}
