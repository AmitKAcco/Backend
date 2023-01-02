package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Feedback;
import com.auGrad.Backend.model.MockInterview;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MockInterviewService {

    MockInterview createMockInterview(MockInterview mockInterview);

    List<MockInterview> getMockInterview();

    List<MockInterview> getMockInterviewByBatchId(int batchId);
}
