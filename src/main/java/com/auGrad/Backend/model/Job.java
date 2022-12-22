package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@Table(name="job")
public class Job {
    //PK
    @Id
    @Column(name="job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    @Column(name="client")
    private String client;

    @Column(name="openings")
    private int openings;
}
