package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementsRepo extends JpaRepository<Requirements,Integer> {
}
