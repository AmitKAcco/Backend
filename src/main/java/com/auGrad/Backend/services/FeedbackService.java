package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {

    Feedback createFeedback(Feedback feedback);

    List<Feedback> getFeedback();

    Feedback getFeedbackByBatchId(int batchId);
}
