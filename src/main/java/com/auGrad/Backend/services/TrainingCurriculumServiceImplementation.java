package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Batch;
import com.auGrad.Backend.model.TrainingCurriculum;
import com.auGrad.Backend.repository.BatchRepo;
import com.auGrad.Backend.repository.TrainingCurriculumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrainingCurriculumServiceImplementation implements TrainingCurriculumService {
    @Autowired
    private TrainingCurriculumRepo trainingCurriculumRepo;


    @Autowired
    TrainingCurriculum trainingCurriculumAdded;

    @Autowired
    private Batch batch;

    @Autowired
    private BatchRepo batchRepo;
    @Override
    public TrainingCurriculum createTopic(TrainingCurriculum trainingCurriculum){
        TrainingCurriculum trainingCurriculumAdded =  trainingCurriculumRepo.save(trainingCurriculum);
        Optional<Batch> obj = batchRepo.findByBatchName(trainingCurriculum.getBatchName());
//   Optional<Batch> objBatch = batchRepo.findById(mockInterview.getBatchId());

        if(obj.isPresent()) {
            Batch b = obj.get();
            trainingCurriculumAdded.setBatchId(b.getBatchId());
        }
        trainingCurriculumRepo.save(trainingCurriculumAdded);
        return trainingCurriculumAdded;

    }

    @Override
    public List<TrainingCurriculum> getTopics(){

        return this.trainingCurriculumRepo.findAll();
    }

    @Override
    public List<TrainingCurriculum> getTrainingCurriculumTopicByBatchId(int batchId){

        return this.trainingCurriculumRepo.findByBatchId(batchId);
    }
}



