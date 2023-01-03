package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.ProjectCalendar;
import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.services.ProjectCalendarService;
import com.auGrad.Backend.services.ProjectTopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectCalendarController {

        @Autowired
        private ProjectCalendarService projectCalendarService;
        @PostMapping("/addProjectCalendar")
        private ResponseEntity<ProjectCalendar> saveProjectCalendar(@RequestBody ProjectCalendar projectCalendar){
            try {

                return ResponseEntity.ok().body(this.projectCalendarService.createProjectCalendar(projectCalendar));
            }
            catch (Exception e){
                throw new NoObjectFoundException("Project calendar already exists");
            }
        }

        @GetMapping("/allProjectCalendar")
        private ResponseEntity<List<ProjectCalendar>> getAllProjectCalendar(){
            return ResponseEntity.ok().body(this.projectCalendarService.getProjectCalendar());
        }

        @GetMapping("/projectCalendarByBatchId/{batchId}")
        private ResponseEntity<List<ProjectCalendar>> getProjectCalendarByBatchId(@PathVariable int batchId)
        {
            return ResponseEntity.ok().body(this.projectCalendarService.getProjectCalendarByBatchId(batchId));
        }
}
