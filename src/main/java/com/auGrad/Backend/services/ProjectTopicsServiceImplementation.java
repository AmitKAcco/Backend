package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.CheckBlocked;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.ProjectTopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTopicsServiceImplementation implements ProjectTopicsService{
    @Autowired
    private ProjectTopicRepo projectTopicRepo;

    @Autowired
    private ProjectTopics projectTopicsAdded;

    @Autowired
    private Batch batch;
    @Autowired
    private BatchRepo batchRepo;
    @Override
    public String createProjectTopics(ProjectTopics projectTopics){
        Optional<ProjectTopics> objMob = this.projectTopicRepo.findByProjectName(projectTopics.getProjectName());
        if(objMob.isPresent())
        {
            return("Project Topic Already exists");
        }
        ProjectTopics projectTopics1 = new ProjectTopics();
        //projectTopics1.setBatchId(projectTopics.getBatchId());
        projectTopics1.setProjectName(projectTopics.getProjectName());
        projectTopics1.setBatchName(projectTopics.getBatchName());
        Optional<Batch> obj3 = batchRepo.findByBatchName(projectTopics.getBatchName());


        if(obj3.isPresent()){
            Batch b = obj3.get();
            projectTopics1.setBatchId(b.getBatchId());
            projectTopics.setBatchId(b.getBatchId());
            // interviewAdded.setBatchId(e.getBatchN());
        }


        //ProjectTopics projectTopicsAdded=  projectTopicRepo.save(projectTopics);
        projectTopicRepo.save(projectTopics1);
        return ("Project Topic Added");

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
