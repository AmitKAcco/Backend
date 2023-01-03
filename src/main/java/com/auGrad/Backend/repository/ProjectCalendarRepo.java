package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.ProjectCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectCalendarRepo extends JpaRepository<ProjectCalendar,Integer> {
    List<ProjectCalendar> findByBatchId(int batchId);
}
