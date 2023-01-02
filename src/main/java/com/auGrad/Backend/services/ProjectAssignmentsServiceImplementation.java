package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectAssignments;
import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.model.TrainingCurriculum;
import com.auGrad.Backend.repository.ProjectAssignmentsRepo;
import com.auGrad.Backend.repository.ProjectTopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectAssignmentsServiceImplementation implements ProjectAssignmentsService{
    @Autowired
    private ProjectAssignmentsRepo projectAssignmentsRepo;

    @Autowired
    private ProjectAssignments projectAssignmentsAdded;

    @Autowired
    private ProjectTopics projectTopics;

    @Autowired
    private ProjectTopicRepo projectTopicRepo;
    @Override
    public ProjectAssignments createProjectAssignments(ProjectAssignments projectAssignments){
        ProjectAssignments projectAssignmentsAdded =  projectAssignmentsRepo.save(projectAssignments);
        Optional<ProjectTopics> projectTopics1 = projectTopicRepo.findByName(projectAssignments.getProjectName());
        if(projectTopics1.isPresent()){
            ProjectTopics pt=projectTopics1.get();
            projectAssignmentsAdded.setProjectId(pt.getProjectId());
        }
        projectAssignmentsRepo.save(projectAssignmentsAdded);
        return projectAssignmentsAdded;

    }

    @Override
    public List<ProjectAssignments> getProjectAssignments(){

        return this.projectAssignmentsRepo.findAll();
    }
}
