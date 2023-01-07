package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.CheckBlocked;
import com.auGrad.Backend.model.Job;
import com.auGrad.Backend.model.Login;
import com.auGrad.Backend.services.JobService;
import com.auGrad.Backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/createLogin")
    private ResponseEntity<Login> saveLogin(@RequestBody Login login){
        try {

            return ResponseEntity.ok().body(this.loginService.createLogin(login));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Login already exists");
        }
    }

//    @GetMapping("/all")
//    private ResponseEntity<List<Job>> getAllJobs(){
//        return ResponseEntity.ok().body(this.jobService.getJob());
//    }

//    @GetMapping("/getLogin/{userName}")
//    private ResponseEntity<Login> getCheckedBlockedByBatchId(@PathVariable String userName)
//    {
//        return ResponseEntity.ok().body(this.loginService.getLoginByuserName(userName));
//    }
    @GetMapping("/LoginByUserName/{userName}")
    private ResponseEntity<Login> getLoginByEmpId(@PathVariable String userName)
    {
        return ResponseEntity.ok().body(this.loginService.getLoginByuserName(userName));
    }
}
