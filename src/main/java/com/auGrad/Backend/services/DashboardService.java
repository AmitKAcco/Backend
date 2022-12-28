package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Dashboard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashboardService {

    Dashboard createDashboard(Dashboard dashboard);

    List<Dashboard> getDashboard();

}
