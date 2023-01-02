package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.TrainingCurriculum;
import com.auGrad.Backend.services.EmployeeService;
import com.auGrad.Backend.services.TrainingCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TrainingCurriculumController {


        @Autowired
        private TrainingCurriculumService trainingCurriculumService;

        @PostMapping("/addTopic")
        private ResponseEntity<TrainingCurriculum> saveTopic(@RequestBody TrainingCurriculum trainingCurriculum){
            try {

                return ResponseEntity.ok().body(this.trainingCurriculumService.createTopic(trainingCurriculum));
            }
            catch (Exception e){
                throw new NoObjectFoundException("Topic already exists");
            }
        }

        @GetMapping("/allTopics")
        private ResponseEntity<List<TrainingCurriculum>> getAllTopics(){
            return ResponseEntity.ok().body(this.trainingCurriculumService.getTopics());
        }

    @GetMapping("/trainingCurriculumByBatchId/{batchId}")
    private ResponseEntity<List<TrainingCurriculum>> getTrainingCurriculumByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.trainingCurriculumService.getTrainingCurriculumTopicByBatchId(batchId));
    }
}
