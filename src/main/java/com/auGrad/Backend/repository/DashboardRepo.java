package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepo extends JpaRepository<Dashboard,Integer> {
}
