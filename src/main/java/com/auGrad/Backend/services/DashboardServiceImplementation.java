package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.repository.DashboardRepo;
import com.auGrad.Backend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardServiceImplementation implements DashboardService{

    @Autowired
    private DashboardRepo dashboardRepo;

    @Autowired
    private  Dashboard dashboardAdded;

    @Autowired
    private Employee employee;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Dashboard createDashboard(Dashboard dashboard) {
        Dashboard dashboardAdded = dashboardRepo.save(dashboard);
       // List<Employee> employee1 = employeeRepo.findAllByBatchId(dashboard.getBatchId());
        return dashboardAdded;
    }

    @Override
    public List<Dashboard> getDashboard() {
        return this.dashboardRepo.findAll();
    }

    @Override
    public Dashboard getDashboardByBatchId(int batchId){

        return this.dashboardRepo.findByBatchId(batchId);
    }
}
