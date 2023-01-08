package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Interview;
import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface InterviewService {

    Interview createInterview(Interview interview);

    List<Interview> getInterview();

    Interview getInterviewByBatchId(int batchId);

    List<Integer> getEmpScheduledInterview(Blocked checkInterviewScheduled);

    int updateInterviewForSelectedFunc(Interview empData);
}
