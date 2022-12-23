package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepo extends JpaRepository<Interview,Integer> {
}
