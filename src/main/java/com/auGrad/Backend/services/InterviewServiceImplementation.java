package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Interview;
import com.auGrad.Backend.repository.InterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImplementation implements InterviewService{
    @Autowired
    private InterviewRepo interviewRepo;
    @Override
    public Interview createInterview(Interview interview) {
        Interview interviewAdded = interviewRepo.save(interview);
        return interviewAdded;
    }

    @Override
    public List<Interview> getInterview() {
        return this.interviewRepo.findAll();
    }
}
