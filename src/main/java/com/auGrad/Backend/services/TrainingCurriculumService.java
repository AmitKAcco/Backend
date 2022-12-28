package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.TrainingCurriculum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingCurriculumService {
    TrainingCurriculum createTopic(TrainingCurriculum trainingCurriculum);

    List<TrainingCurriculum> getTopics();
}
