package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectAssignments;

import java.util.List;

public interface ProjectAssignmentsService {
    ProjectAssignments createProjectAssignments(ProjectAssignments projectAssignments);

    List<ProjectAssignments> getProjectAssignments();

    List<ProjectAssignments> getProjectAssignmentsByBatchId(int batchId);
}
