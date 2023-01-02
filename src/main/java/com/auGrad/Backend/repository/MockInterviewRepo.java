package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.MockInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockInterviewRepo extends JpaRepository<MockInterview,Integer> {
    List<MockInterview> findByBatchId(int batchId);
}
