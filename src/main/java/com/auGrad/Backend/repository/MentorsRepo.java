package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Mentors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorsRepo extends JpaRepository<Mentors,Integer> {
    List<Mentors> findByBatchId(int batchId);

//    @Query("Select  from Transaction t where t.userId=?1")
//    String findNameById(int mentorId);
}
