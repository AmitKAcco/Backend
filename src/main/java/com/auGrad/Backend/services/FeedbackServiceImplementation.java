package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Feedback;
import com.auGrad.Backend.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImplementation implements FeedbackService{
    @Autowired
    private FeedbackRepo feedbackRepo;
    @Override
    public Feedback createFeedback(Feedback feedback) {


        Feedback feedbackAdded = feedbackRepo.save(feedback);
        return feedbackAdded;
    }

    @Override
    public List<Feedback> getFeedback() {
        return this.feedbackRepo.findAll();
    }
}
