package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.CheckBlocked;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.repository.BlockedRepo;
import com.auGrad.Backend.repository.CheckBlockedRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckBlockedServiceImplementation implements CheckBlockedService{

    @Autowired
    private CheckBlockedRepo checkBlockedRepo;

    @Autowired
    private BlockedRepo blockedRepo;

    @Autowired
    private Blocked blocked;

    @Autowired
    private CheckBlocked checkBlockedAdded;

    @Autowired
    private Employee employee;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Job job;

    @Autowired
    private JobRepo jobRepo;
//    @Autowired
//    private  CheckBlocked checkBlockedAdded ;
    @Override
    public CheckBlocked createCheckBlocked(CheckBlocked checkBlocked){

        CheckBlocked check = new CheckBlocked();
        check.setBatchId(checkBlocked.getBatchId());
        check.setEmpId(checkBlocked.getEmpId());
        check.setJobId(checkBlocked.getJobId());

        Optional<Employee> employeeobj1 = employeeRepo.findById(checkBlocked.getEmpId());
        if(employeeobj1.isPresent()){
            Employee e=employeeobj1.get();
            check.setEmpName(e.getEmployeeName());
        }
        Optional<Job> jobobj = jobRepo.findById(checkBlocked.getJobId());
        if(jobobj.isPresent()){
            Job j=jobobj.get();
//            checkBlockedAdded.setClient(j.getClient());
            check.setClient(j.getClient());
        }
        //mentorsAdded.setMentorName(employee.getEmployeeName(employeeRepo.findAllById(mentorsAdded.getMentorId())));
//        checkBlockedRepo.save(checkBlockedAdded);

        List<Integer> blockedobj1 = blockedRepo.findBlockedIdByJobId(checkBlocked.getJobId());
        List<Integer> blockedobj2 = blockedRepo.findBlockedIdByEmpId(checkBlocked.getEmpId());

        for(Integer i : blockedobj1){
            for(Integer j : blockedobj2){
                if(i.equals(j)){
                    check.setBlockStatus(true);
                } else {
                    check.setBlockStatus(false);
                }
            }
        }
        checkBlockedRepo.save(check);

//        if(blockedobj1.isPresent() && blockedobj2.isPresent()){
//
//                Blocked b1=blockedobj1.get();
//                Blocked b2=blockedobj2.get();
//                Integer x = b1.getBlockedId();
//                Integer y = b2.getBlockedId();
//                System.out.println(x + " " + y);
//                System.out.print("hello world");
//                if(x.equals(y)){
//
//                    checkBlockedAdded.setBlockStatus(true);
//                }
//                else {
//                    checkBlockedAdded.setBlockStatus(false);
//                }
//
//        }
//        //mentorsAdded.setMentorName(employee.getEmployeeName(employeeRepo.findAllById(mentorsAdded.getMentorId())));
//        checkBlockedRepo.save(checkBlockedAdded);



        return check;



    }



    @Override
    public List<CheckBlocked> getCheckedBlocked(){

        return this.checkBlockedRepo.findAll();
    }
}
