package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Job;

import java.util.List;

public interface JobService {
    Job createJob(Job job);

    List<Job> getJob();
}
