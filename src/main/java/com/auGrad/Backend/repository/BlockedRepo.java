package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.Employee;
import com.auGrad.Backend.model.TrainingCurriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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


    @Query("Select b  from Blocked b where b.batchId=?1")
    List<Employee> findAllByBatchId(int batchId);

    Blocked findByBatchId(int batchId);

    @Modifying()
    @Query("update Blocked b set b.interviewScheduled = true where b.empId =?1")
    void updateBlockedForInterviewScheduled(int empId, int jobId);

    @Modifying()
    @Query("update Blocked b set b.selected = true where b.empId =?1")
    void updateBlockedForSelected(int empId, int jobId);
//
}
