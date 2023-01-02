package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashboardService {

    Dashboard createDashboard(Dashboard dashboard);

    List<Dashboard> getDashboard();

    Dashboard getDashboardByBatchId(int batchId);
}
