package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectAssignments;
import com.auGrad.Backend.repository.ProjectAssignmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectAssignmentsServiceImplementation implements ProjectAssignmentsService{
    @Autowired
    private ProjectAssignmentsRepo projectAssignmentsRepo;

    @Autowired
    private ProjectAssignments projectAssignmentsAdded;
    @Override
    public ProjectAssignments createProjectAssignments(ProjectAssignments projectAssignments){
        ProjectAssignments projectAssignmentsAdded =  projectAssignmentsRepo.save(projectAssignments);

        return projectAssignmentsAdded;

    }

    @Override
    public List<ProjectAssignments> getProjectAssignments(){

        return this.projectAssignmentsRepo.findAll();
    }
}
