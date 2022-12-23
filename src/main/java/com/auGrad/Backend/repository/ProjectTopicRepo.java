package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.ProjectTopics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTopicRepo extends JpaRepository<ProjectTopics,Integer> {
}
