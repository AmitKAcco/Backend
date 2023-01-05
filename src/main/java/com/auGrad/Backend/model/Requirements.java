package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Component
//500
@SequenceGenerator(name="seqReq", initialValue=500,allocationSize=1)

@Table(name = "Requirements")
public class Requirements {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReq")
    @Column(name = "requirement_id")
    private int requirementId;

    @Column(name = "batch_id")
    private int batchId; // Foreign Key
    @Column(name = "batchName")
    private String batchName;
    @Column(name="job_id")
    private int jobId;

    @Column(name = "no_of_positions")
    private int noOfPositions;

    @Column(name = "stakeholder")
    private String stakeholder;

    @Column(name = "department")
    private String department;

    @Column(name = "location")
    private String location;

    @Column(name = "gender")
    private String gender;

    @Column(name="client")
    private String client;

    @Column(name = "vertical")
    private String vertical;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;

    @ManyToMany(targetEntity = Job.class, cascade = CascadeType.ALL, mappedBy = "requirementsList")
//    @JoinColumn(name = "job_id", referencedColumnName = "job_id", insertable = false, updatable = false)

    private List<Job> jobList;


}
