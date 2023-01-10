package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.ProjectTopics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectTopicRepo extends JpaRepository<ProjectTopics,Integer> {
    @Query("Select i from ProjectTopics i where i.projectName=?1")
    Optional<ProjectTopics> findByName(String projectName);

    List<ProjectTopics> findByBatchId(int batchId);

    Optional<ProjectTopics> findByProjectName(String projectName);
}
