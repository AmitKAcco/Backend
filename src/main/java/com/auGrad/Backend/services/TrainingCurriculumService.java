package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.TrainingCurriculum;

import java.util.List;

public interface TrainingCurriculumService {
    TrainingCurriculum createTopic(TrainingCurriculum trainingCurriculum);

    List<TrainingCurriculum> getTopics();
}
