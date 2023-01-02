package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {
    @Query("Select f  from Feedback f where f.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    Feedback findByBatchId(int batchId);
}
