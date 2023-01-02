package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectTopics;

import java.util.List;

public interface ProjectTopicsService {
    ProjectTopics createProjectTopics(ProjectTopics projectTopics);

    List<ProjectTopics> getProjectTopics();

    List<ProjectTopics> getProjectTopicsByBatchId(int batchId);
}
