package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Selected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SelectedRepo extends JpaRepository<Selected,Integer> {
    List<Selected> findByEmpId(int empId);

    @Query("Select s.empId from Selected s")
    List<Integer> findAllEmpId();

}