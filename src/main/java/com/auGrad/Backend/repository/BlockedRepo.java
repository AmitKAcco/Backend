package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.TrainingCurriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlockedRepo extends JpaRepository<Blocked,Integer> {

    @Query("Select b.blockedId from Blocked b where b.jobId=?1")
    List<Integer> findBlockedIdByJobId(int jobId);

    @Query("Select b.blockedId from Blocked b where b.empId=?1")
    List<Integer> findBlockedIdByEmpId(int empId);


}
