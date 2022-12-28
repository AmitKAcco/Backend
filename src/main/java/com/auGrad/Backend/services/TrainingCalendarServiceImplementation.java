package com.auGrad.Backend.services;

import com.auGrad.Backend.model.TrainingCalendar;
import com.auGrad.Backend.repository.TrainingCalendarRepo;
import com.auGrad.Backend.repository.TrainingCurriculumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCalendarServiceImplementation implements TrainingCalendarService{
    @Autowired

    private TrainingCalendarRepo trainingCalendarRepo;
    @Autowired
    private TrainingCurriculumRepo trainingCurriculumRepo;

    @Autowired
    private TrainingCalendar trainingCalendarAdded;
    @Override
    public TrainingCalendar createTrainingCalendar(TrainingCalendar trainingCalendar){
        TrainingCalendar trainingCalendarAdded =  trainingCalendarRepo.save(trainingCalendar);
        trainingCalendarAdded.setTopicId((Integer) trainingCalendarRepo.findTopicByTopicId(trainingCalendar.getTrainingTopicName()));
        return trainingCalendarAdded;

    }

    @Override
    public List<TrainingCalendar> getTrainingCalendar(){

        return this.trainingCalendarRepo.findAll();
    }
}
