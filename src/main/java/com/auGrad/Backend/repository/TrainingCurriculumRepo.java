package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.TrainingCurriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCurriculumRepo extends JpaRepository<TrainingCurriculum,Integer> {
}