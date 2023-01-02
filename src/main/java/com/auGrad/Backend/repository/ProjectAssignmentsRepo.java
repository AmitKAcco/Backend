package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.ProjectAssignments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectAssignmentsRepo extends JpaRepository<ProjectAssignments,Integer> {

}