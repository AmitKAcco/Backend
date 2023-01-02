package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Interview;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface InterviewService {

    Interview createInterview(Interview interview);

    List<Interview> getInterview();

    Interview getInterviewByBatchId(int batchId);
}
