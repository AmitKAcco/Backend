package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.TrainingCurriculum;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.TrainingCurriculumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class TrainingCurriculumServiceImplementation implements TrainingCurriculumService {
    @Autowired
    private TrainingCurriculumRepo trainingCurriculumRepo;


    @Autowired
    TrainingCurriculum trainingCurriculumAdded;
    @Override
    public TrainingCurriculum createTopic(TrainingCurriculum trainingCurriculum){
        TrainingCurriculum trainingCurriculumAdded =  trainingCurriculumRepo.save(trainingCurriculum);
        return trainingCurriculumAdded;

    }

    @Override
    public List<TrainingCurriculum> getTopics(){

        return this.trainingCurriculumRepo.findAll();
    }

}

