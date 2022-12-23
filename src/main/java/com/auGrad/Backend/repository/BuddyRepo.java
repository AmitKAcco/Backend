package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Buddy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddyRepo extends JpaRepository<Buddy,Integer> {
}
