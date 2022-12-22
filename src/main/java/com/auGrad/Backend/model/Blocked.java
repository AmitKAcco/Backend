package com.auGrad.Backend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@Table(name="blocked")
public class Blocked {
    //PK
    @Id
    @Column(name="blocked_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blockedId;
    //FK
    @Column(name="batch_id")
    private int batchId;
    //FK
    @Column(name="emp_id")
    private int empId;
    //FK
    @Column(name="job_id")
    private int jobId;



    @Column(name="client")
    private int client;




}
