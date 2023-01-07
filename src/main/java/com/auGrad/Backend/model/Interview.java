package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
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
    @Column(name = "batchName")
    private String batchName;
    @Column(name = "emp_id")
    private int empId; //Foreign Key
    @Column(name = "grad_name")
    private String gradName;
    @Column(name = "job_id")
    private int jobId; // Foreign Key

    @Column(name = "interview_date")
    private Date interviewDate;
    @Column(name = "time")
    private String time;
    @Column(name = "block_status")
    private boolean block_status;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)

    private List<Employee> employeeList;

    @ManyToMany(targetEntity = Job.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", insertable = false, updatable = false)

    private List<Job> jobList;


    @ManyToMany(targetEntity = Blocked.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "blocked_id", referencedColumnName = "blocked_id", insertable = false, updatable = false)

    private List<Blocked> blockedList;

}
