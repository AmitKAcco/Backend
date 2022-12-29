package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Interview;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.repository.BlockedRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.InterviewRepo;
import com.auGrad.Backend.repository.JobRepo;
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
    private EmployeeRepo employeeRepo;

    @Autowired
    private Blocked b;
    @Autowired
    private Blocked b1;

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



        Optional<Employee> employeeobj1 = employeeRepo.findById(interview.getEmpId());
        if(employeeobj1.isPresent()){
            Employee e=employeeobj1.get();
            interviewAdded.setGradName(e.getEmployeeName());
            obj.setEmpName(e.getEmployeeName());

        }
        Optional<Job> jobobj = jobRepo.findById(interview.getEmpId());
        if(jobobj.isPresent()){
            Job j = jobobj.get();
            //interviewAdded.setGradName(j.getClient());
            obj.setClient(j.getClient());


        }
        blockedRepo.save(obj);

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
}
