package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Blocked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockedRepo extends JpaRepository<Blocked,Integer> {
}
