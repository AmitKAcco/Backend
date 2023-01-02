package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Mentors;
import com.auGrad.Backend.model.ProjectAssignments;
import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.services.MentorsService;
import com.auGrad.Backend.services.ProjectAssignmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProjectAssignmentsController {

    @Autowired
    private ProjectAssignmentsService projectAssignmentsService;

    @PostMapping("/addProjectAssignments")
    private ResponseEntity<ProjectAssignments> saveProjectAssignments(@RequestBody ProjectAssignments projectAssignments){
        try {
            System.out.println(" iam here");
            return ResponseEntity.ok().body(this.projectAssignmentsService.createProjectAssignments(projectAssignments));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Project Assignments already exists");
        }
    }
@PostMapping("/listProjectAssignments")
public List<ProjectAssignments> createProjectAssignmentList(@RequestBody List<ProjectAssignments> projectAssignmentsList) {
    return projectAssignmentsService.saveAll(projectAssignmentsList);
}

    @GetMapping("/allProjectAssignments")
    private ResponseEntity<List<ProjectAssignments>> getAllProjectAssignments(){
        return ResponseEntity.ok().body(this.projectAssignmentsService.getProjectAssignments());
    }

    @GetMapping("/projectAssignmentsByBatchId/{batchId}")
    private ResponseEntity<List<ProjectAssignments>> getProjectAssignmentsByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.projectAssignmentsService.getProjectAssignmentsByBatchId(batchId));
    }
}

