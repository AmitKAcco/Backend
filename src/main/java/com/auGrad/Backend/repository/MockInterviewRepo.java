package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.MockInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockInterviewRepo extends JpaRepository<MockInterview,Integer> {
}
