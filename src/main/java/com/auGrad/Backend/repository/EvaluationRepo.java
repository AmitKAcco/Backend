package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation,Integer> {
    @Query("Select e  from Evaluation e where e.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    Evaluation findByBatchId(int batchId);
}
