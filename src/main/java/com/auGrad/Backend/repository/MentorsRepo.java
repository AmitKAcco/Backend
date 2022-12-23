package com.auGrad.Backend.repository;


import com.auGrad.Backend.model.Mentors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorsRepo extends JpaRepository<Mentors,Integer> {
}
