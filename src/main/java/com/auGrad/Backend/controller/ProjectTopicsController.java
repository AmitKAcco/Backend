package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Mentors;
import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.services.MentorsService;
import com.auGrad.Backend.services.ProjectTopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectTopicsController {
    @Autowired
    private ProjectTopicsService projectTopicsService;
    @PostMapping("/addProjectTopics")
    private ResponseEntity<ProjectTopics> saveProjectTopics(@RequestBody ProjectTopics projectTopics){
        try {

            return ResponseEntity.ok().body(this.projectTopicsService.createProjectTopics(projectTopics));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Project topic already exists");
        }
    }

    @GetMapping("/allProjectTopics")
    private ResponseEntity<List<ProjectTopics>> getAllProjectTopics(){
        return ResponseEntity.ok().body(this.projectTopicsService.getProjectTopics());
    }
}