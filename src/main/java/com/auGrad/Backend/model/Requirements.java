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
@Table(name = "Requirements")
public class Requirements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requirement_id")
    private int requirementId;

    @Column(name = "batch_id")
    private int batchId; // Foreign Key

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

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;

    @ManyToMany(targetEntity = Job.class, cascade = CascadeType.ALL, mappedBy = "requirementsList")
//    @JoinColumn(name = "job_id", referencedColumnName = "job_id", insertable = false, updatable = false)

    private List<Job> jobList;


}
