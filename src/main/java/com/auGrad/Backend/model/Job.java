package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

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


    @Column(name="blocked_id")
    private int blockedId;

    @Column(name="client")
    private String client;

    @Column(name="openings")
    private int openings;

    @Column(name = "requirement_id")
    private int requirement_id;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;


    @ManyToMany(targetEntity = Requirements.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "requirement_id", referencedColumnName = "requirement_id", insertable = false, updatable = false)

    private List<Requirements> requirementsList;


    @ManyToMany(targetEntity = Blocked.class, cascade = CascadeType.ALL, mappedBy = "jobList")
//    @JoinColumn(name = "blocked_id", referencedColumnName = "blocked_id", insertable = false, updatable = false)

    private List<Blocked> blockedList;



}
