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
@Table(name="check_blocked")
public class CheckBlocked {
    //PK
    @Id
    @Column(name="checked_blocked_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int checkedBlockedId;

    //FK
    @Column(name="batch_id")
    private int batchId;
    @Column(name = "batchName")
    private String batchName;

    //FK
    @Column(name="emp_id")
    private int empId;



    @Column(name="emp_name")
    private String empName;

    @Column(name="job_id")
    private int jobId;

    @Column(name="client")
    private String client;

//    @Column(name="blocked_id")
//    private int blockedId;

    @Column(name="block_status")
    private boolean blockStatus;



//
//    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
//
//    private List<Batch> batchesList;
//
//    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
//
//    private List<Employee> employeeList;

}

