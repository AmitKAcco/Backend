package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.TrainerAssigned;
import com.auGrad.Backend.model.TrainingCurriculum;
import com.auGrad.Backend.repository.EmployeeRepo;
import com.auGrad.Backend.repository.TrainerAssignedRepo;
import com.auGrad.Backend.repository.TrainingCurriculumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerAssignedServiceImplementation implements TrainerAssignedService{
    @Autowired
    private TrainerAssignedRepo trainerAssignedRepo;

    @Autowired
    private TrainerAssigned trainerAssignedAdded;

    @Autowired
    private TrainingCurriculum trainingCurriculum;
    @Autowired
    private TrainingCurriculumRepo trainingCurriculumRepo;
    @Override
    public TrainerAssigned createTrainerAssigned(TrainerAssigned trainerAssigned){
        TrainerAssigned trainerAssignedAdded=  trainerAssignedRepo.save(trainerAssigned);
        Optional<TrainingCurriculum> trainingCurriculumobj1 = trainingCurriculumRepo.findByName(trainerAssigned.getTopicName());
        if(trainingCurriculumobj1.isPresent()){
            TrainingCurriculum tc=trainingCurriculumobj1.get();
            trainerAssignedAdded.setTopicId(tc.getTopicId());
        }

        //mentorsAdded.setMentorName(employee.getEmployeeName(employeeRepo.findAllById(mentorsAdded.getMentorId())));
        trainerAssignedRepo.save(trainerAssignedAdded);
        return trainerAssignedAdded;

    }

    @Override
    public List<TrainerAssigned> getTrainerAssigned(){

        return this.trainerAssignedRepo.findAll();
    }
}
