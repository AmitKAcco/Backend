package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.TrainingCurriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingCurriculumRepo extends JpaRepository<TrainingCurriculum,Integer> {

    @Query("Select i from TrainingCurriculum i where i.topicName=?1")
    Optional<TrainingCurriculum> findByName(String topicName);
    //  Optional<TrainingCurriculum> findbyName(String topicName);
    // Optional<TrainingCurriculum> findIdbyName(String topicName);
}