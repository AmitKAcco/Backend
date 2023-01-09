package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.ProjectCalendar;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.ProjectCalendarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectCalendarServiceImplementation implements  ProjectCalendarService{

    @Autowired
    private ProjectCalendarRepo projectCalendarRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private ProjectCalendar projectCalendarAdded;
    @Override
    public ProjectCalendar createProjectCalendar(ProjectCalendar projectCalendar){
//        ProjectTopics projectTopics1 = new ProjectTopics();
//        projectTopics1.setBatchId(projectTopics.getBatchId());
//        projectTopics1.setProjectName(projectTopics.getProjectName());

        ProjectCalendar projectCalendarAdded=  projectCalendarRepo.save(projectCalendar);
        Optional<Batch> obj3 = batchRepo.findByBatchName(projectCalendar.getBatchName());


        if(obj3.isPresent()){
            Batch b = obj3.get();
            projectCalendarAdded.setBatchId(b.getBatchId());
            // interviewAdded.setBatchId(e.getBatchN());
        }

        projectCalendarRepo.save(projectCalendarAdded);
        return projectCalendarAdded;

    }

    @Override
    public List<ProjectCalendar> getProjectCalendar(){

        return this.projectCalendarRepo.findAll();
    }

    @Override
    public List<ProjectCalendar> getProjectCalendarByBatchId(int batchId){

        return this.projectCalendarRepo.findByBatchId(batchId);
    }
}
