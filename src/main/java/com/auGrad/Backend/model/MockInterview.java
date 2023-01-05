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
@Table(name = "MockInterview")
public class MockInterview {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mock_id")
    private int mockId;
    @Column(name = "emp_id")
    private int empId; // Foreign Key
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "interviewer_name")
    private String interviewerName;
    @Column(name = "interview_date")
    private Date interviewDate;
    @Column(name = "time")
    private String time;
    @Column(name = "batch_id")
    private int batchId;
    @Column(name = "batchName")
    private String batchName;// Foreign Key

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)

    private List<Employee> employeeList;


}
