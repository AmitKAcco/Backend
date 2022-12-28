package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.repository.DashboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImplementation implements DashboardService{

    @Autowired
    private DashboardRepo dashboardRepo;

    @Override
    public Dashboard createDashboard(Dashboard dashboard) {
        Dashboard dashboardAdded = dashboardRepo.save(dashboard);
        return dashboardAdded;
    }

    @Override
    public List<Dashboard> getDashboard() {
        return this.dashboardRepo.findAll();
    }
}
