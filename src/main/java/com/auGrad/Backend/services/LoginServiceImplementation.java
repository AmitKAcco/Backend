package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Login;
import com.auGrad.Backend.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplementation implements LoginService {
    @Autowired
    private LoginRepo loginRepo;

    @Override
    public Login createLogin(Login login) {
        return this.loginRepo.save(login);
    }

    @Override
    public Login getLoginByuserName(String userName) {
        return this.loginRepo.findByUserName(userName);
    }
}
