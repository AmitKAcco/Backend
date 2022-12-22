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

    @OneToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;

    @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")

    private List<Employee> employeeList;

    @OneToMany(targetEntity = Job.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")

    private List<Job> jobList;



}
