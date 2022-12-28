package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Mentors;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.MentorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorsServiceImplementation implements MentorsService{
    @Autowired
    private MentorsRepo mentorsRepo;

    @Autowired
    private Mentors mentorsAdded;

    @Autowired
    private Employee employee;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override

    public Mentors createMentor(Mentors mentors){
        Mentors mentorsAdded =  mentorsRepo.save(mentors);
        Optional<Employee> employeeobj1 = employeeRepo.findById(mentors.getEmpIdMentor());
        if(employeeobj1.isPresent()){
            Employee e=employeeobj1.get();
            mentorsAdded.setMentorName(e.getEmployeeName());
        }
        Optional<Employee> employeeobj2 = employeeRepo.findById(mentors.getEmpIdGrad());
        if(employeeobj2.isPresent()){
            Employee e=employeeobj2.get();
            mentorsAdded.setMentorName(e.getEmployeeName());
        }
        //mentorsAdded.setMentorName(employee.getEmployeeName(employeeRepo.findAllById(mentorsAdded.getMentorId())));
        mentorsRepo.save(mentorsAdded);
        return mentorsAdded;

    }

    @Override
    public List<Mentors> getMentors(){

        return this.mentorsRepo.findAll();
    }
}
