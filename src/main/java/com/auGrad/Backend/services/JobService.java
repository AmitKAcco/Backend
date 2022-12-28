package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    Job createJob(Job job);

    List<Job> getJob();
}
