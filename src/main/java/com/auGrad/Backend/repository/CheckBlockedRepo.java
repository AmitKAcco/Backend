package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.CheckBlocked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CheckBlockedRepo extends JpaRepository<CheckBlocked,Integer> {
}
