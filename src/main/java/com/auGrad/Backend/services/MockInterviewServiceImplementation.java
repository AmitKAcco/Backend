package com.auGrad.Backend.services;

import com.auGrad.Backend.model.MockInterview;
import com.auGrad.Backend.repository.MockInterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockInterviewServiceImplementation implements MockInterviewService {

    @Autowired
    private MockInterviewRepo mockInterviewRepo;

    @Override
    public MockInterview createMockInterview(MockInterview mockInterview) {
        MockInterview mockInterviewAdded = mockInterviewRepo.save(mockInterview);

        return mockInterviewAdded;
    }

    @Override
    public List<MockInterview> getMockInterview() {
        return this.mockInterviewRepo.findAll();
    }
}
