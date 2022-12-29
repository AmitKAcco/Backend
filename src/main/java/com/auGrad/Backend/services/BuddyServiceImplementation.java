package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Buddy;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.repository.BuddyRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuddyServiceImplementation implements BuddyService{

    @Autowired
    private BuddyRepo buddyRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Buddy createBuddy(Buddy buddy) {
        Buddy buddyAdded = buddyRepo.save(buddy);
        Optional<Employee> employeeObj1 = employeeRepo.findById(buddy.getBuddyId());
        if(employeeObj1.isPresent()){
            Employee e = employeeObj1.get();
            buddyAdded.setBuddyName(e.getEmployeeName());
        }
        Optional<Employee> employeeObj2 = employeeRepo.findById(buddy.getGradId());
        if(employeeObj2.isPresent()){
            Employee e = employeeObj2.get();
            buddyAdded.setGradName(e.getEmployeeName());
        }

        buddyRepo.save(buddyAdded);

        return buddyAdded;
    }

    @Override
    public List<Buddy> getBuddy()
    {
        return this.buddyRepo.findAll();
    }
}
