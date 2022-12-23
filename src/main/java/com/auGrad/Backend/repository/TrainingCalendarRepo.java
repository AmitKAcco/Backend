package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.TrainingCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCalendarRepo extends JpaRepository<TrainingCalendar,Integer> {
}
