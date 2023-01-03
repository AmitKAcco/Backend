package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectCalendar;
import com.auGrad.Backend.repository.ProjectCalendarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectCalendarServiceImplementation implements  ProjectCalendarService{

    @Autowired
    private ProjectCalendarRepo projectCalendarRepo;

    @Autowired
    private ProjectCalendar projectCalendarAdded;
    @Override
    public ProjectCalendar createProjectCalendar(ProjectCalendar projectCalendar){
//        ProjectTopics projectTopics1 = new ProjectTopics();
//        projectTopics1.setBatchId(projectTopics.getBatchId());
//        projectTopics1.setProjectName(projectTopics.getProjectName());

        ProjectCalendar projectCalendarAdded=  projectCalendarRepo.save(projectCalendar);
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
