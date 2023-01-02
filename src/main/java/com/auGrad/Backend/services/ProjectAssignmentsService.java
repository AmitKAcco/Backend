package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectAssignments;
import org.apache.catalina.User;

import java.util.List;

public interface ProjectAssignmentsService {
    ProjectAssignments createProjectAssignments(ProjectAssignments projectAssignments);

    List<ProjectAssignments> getProjectAssignments();

    List<ProjectAssignments> saveAll(List<ProjectAssignments> projectAssignmentsList);

}
