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
@Table(name = "ProjectAssignments")
public class ProjectAssignments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")

    private List<Employee> employeeList;


    @ManyToMany(targetEntity = ProjectTopics.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")

    private List<ProjectTopics> projectList;




}
