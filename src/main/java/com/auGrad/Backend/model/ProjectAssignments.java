package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Component
@Table(name = "ProjectAssignments")
public class ProjectAssignments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectAssignments_id")
    private int projectAssignmentsId;

    @Column(name = "batch_id")
    private int batchId; //Foreign Key

    @Column(name = "teamNumber")
    private int teamNumber;

    @Column(name = "emp_id")
    private int empId; // Foreign Key

    @Column(name = "projectLead_1")
    private String projectLead1;

    @Column(name = "projectLead_2")
    private String projectLead2;

    @Column(name = "project_id")
    private int projectId;  //Foreign Key

    @Column(name = "project_name")
    private String projectName;




}
