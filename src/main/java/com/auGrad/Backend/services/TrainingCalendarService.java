package com.auGrad.Backend.services;

import com.auGrad.Backend.model.TrainingCalendar;

import java.util.List;

public interface TrainingCalendarService {
    TrainingCalendar createTrainingCalendar(TrainingCalendar trainingCalendar);

    List<TrainingCalendar> getTrainingCalendar();
}
