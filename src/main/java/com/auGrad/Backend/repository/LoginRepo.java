package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {
    Login findByUserName(String userName);

}
