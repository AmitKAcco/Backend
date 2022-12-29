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
@SequenceGenerator(name="seq7", initialValue=300,allocationSize = 1)
@Table(name="job")
public class Job {
    //PK
    @Id
    @Column(name="job_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq7")
    private int jobId;

    //FK
    @Column(name="batch_id")
    private int batchId;


    @Column(name="blocked_id")
    private int blockedId;

    @Column(name="client")
    private String client;

    @Column(name = "vertical")
    private String vertical;


//    @Column(name="openings")
//    private int openings;

    @Column(name = "requirement_id")
    private int requirement_id;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;


    @ManyToMany(targetEntity = Requirements.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "requirement_id", referencedColumnName = "requirement_id", insertable = false, updatable = false)

    private List<Requirements> requirementsList;


    @ManyToMany(targetEntity = Blocked.class, cascade = CascadeType.ALL, mappedBy = "jobList")
    private List<Blocked> blockedList;


    @ManyToMany(targetEntity = Interview.class, cascade = CascadeType.ALL, mappedBy = "jobList")
    private List<Interview> interviewList;


}
