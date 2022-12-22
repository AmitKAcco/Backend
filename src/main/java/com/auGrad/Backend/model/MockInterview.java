package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

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
    @Column(name = "interviewer_name")
    private String interviewerName;
    @Column(name = "interview_date")
    private Date interviewDate;
    @Column(name = "time")
    private Time time;
    @Column(name = "batch_id")
    private int batchId;  // Foreign Key

}
