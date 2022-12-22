package com.auGrad.Backend.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Data
@Table(name="blocked")
public class Blocked {
    @Column(name="batch_id")
    private int batchId;
    @Column(name="emp_id")
    private int empId;
    @Column(name="job_id")
    private int jobId;

    @Id
    @Column(name="blocked_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blockedId;

    @Column(name="client")
    private int client;




}
