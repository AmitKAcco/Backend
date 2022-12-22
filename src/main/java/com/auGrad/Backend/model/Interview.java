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
@Table(name = "Interview")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private int interviewId;
    @Column(name = "batch_id")
    private int batchId; // Foreign key
    @Column(name = "emp_id")
    private int empId; //Foreign Key
    @Column(name = "grad_name")
    private String gradName;
    @Column(name = "job_id")
    private int jobId; // Foreign Key

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
