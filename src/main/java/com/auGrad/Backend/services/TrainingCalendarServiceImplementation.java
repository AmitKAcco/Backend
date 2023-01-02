package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectTopics;
import com.auGrad.Backend.model.TrainingCalendar;
import com.auGrad.Backend.model.TrainingCurriculum;
import com.auGrad.Backend.repository.TrainingCalendarRepo;
import com.auGrad.Backend.repository.TrainingCurriculumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingCalendarServiceImplementation implements TrainingCalendarService{
    @Autowired

    private TrainingCalendarRepo trainingCalendarRepo;
    @Autowired
    private TrainingCurriculumRepo trainingCurriculumRepo;

    @Autowired
    private TrainingCalendar trainingCalendarAdded;

    @Autowired
    private TrainingCurriculum trainingCurriculum;


    @Override
    public TrainingCalendar createTrainingCalendar(TrainingCalendar trainingCalendar){
        TrainingCalendar trainingCalendarAdded =  trainingCalendarRepo.save(trainingCalendar);
        //trainingCalendarAdded.setTopicId((Integer) trainingCalendarRepo.findTopicByTopicId(trainingCalendar.getTrainingTopicName()));
        Optional<TrainingCurriculum> trainingCurriculum1 = trainingCurriculumRepo.findByName(trainingCalendar.getTrainingTopicName());
        if(trainingCurriculum1.isPresent()){
            TrainingCurriculum tc=trainingCurriculum1.get();
            trainingCalendarAdded.setTopicId(tc.getTopicId());
        }
        trainingCalendarRepo.save(trainingCalendarAdded);
        return trainingCalendarAdded;

    }

    @Override
    public List<TrainingCalendar> getTrainingCalendar(){

        return this.trainingCalendarRepo.findAll();
    }
}
