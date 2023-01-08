package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Interview;
import com.auGrad.Backend.model.Selected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SelectedRepo extends JpaRepository<Selected,Integer> {
    List<Selected> findByEmpIdAndJobId(int empId, int jobId);

    @Query("Select s.empId from Selected s")
    List<Integer> findAllEmpId();
    @Query("Select count(batchId) from   Selected s where s.batchId=?1")
    Integer getCountByBatchId(int batchId);

    void deleteByEmpIdAndJobId(int empId, int jobId);


}