package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.model.Login;

import java.util.List;

public interface LoginService {
    Login createLogin(Login login);
    Login getLoginByuserName(String userName);
}
