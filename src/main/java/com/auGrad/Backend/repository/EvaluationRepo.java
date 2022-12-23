package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation,Integer> {
}
