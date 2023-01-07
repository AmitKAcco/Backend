package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@Table(name="Login")
public class Login {
    @Id
    @Column(name="login_Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq")
    private int login_Id;

    @Column(name="batch_id")
    private int batchId;

    @Column(name = "emp_Id")
    private int empId;


    @Column(name="roles")
    private String role;

    @Column(name="userName")
    private  String userName;

    @Column(name = "password")
    private String password;

}
