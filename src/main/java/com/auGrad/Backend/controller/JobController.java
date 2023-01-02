package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.Dashboard;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Job;

import com.auGrad.Backend.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController
{
    @Autowired
    private JobService jobService;

    @PostMapping("/addJob")
    private ResponseEntity<Job> saveJob(@RequestBody Job job){
        try {

            return ResponseEntity.ok().body(this.jobService.createJob(job));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Job already exists");
        }
    }

    @GetMapping("/allJobs")
    private ResponseEntity<List<Job>> getAllJobs(){
        return ResponseEntity.ok().body(this.jobService.getJob());
    }

    @GetMapping("/jobByBatchId/{batchId}")
    private ResponseEntity<Job> getjobByBatchId(@PathVariable int batchId)
    {
        return ResponseEntity.ok().body(this.jobService.getJobByBatchId(batchId));
    }
}
