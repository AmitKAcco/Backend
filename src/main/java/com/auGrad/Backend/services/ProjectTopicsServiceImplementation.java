package com.auGrad.Backend.services;

import com.auGrad.Backend.model.CheckBlocked;
import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.repository.ProjectTopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTopicsServiceImplementation implements ProjectTopicsService{
    @Autowired
    private ProjectTopicRepo projectTopicRepo;

    @Autowired
    private ProjectTopics projectTopicsAdded;
    @Override
    public ProjectTopics createProjectTopics(ProjectTopics projectTopics){
        ProjectTopics projectTopics1 = new ProjectTopics();
        projectTopics1.setBatchId(projectTopics.getBatchId());
        projectTopics1.setProjectName(projectTopics.getProjectName());

        //ProjectTopics projectTopicsAdded=  projectTopicRepo.save(projectTopics);
        projectTopicRepo.save(projectTopics1);
        return projectTopicsAdded;

    }

    @Override
    public List<ProjectTopics> getProjectTopics(){

        return this.projectTopicRepo.findAll();
    }

    @Override
    public List<ProjectTopics> getProjectTopicsByBatchId(int batchId){

        return this.projectTopicRepo.findByBatchId(batchId);
    }
}
