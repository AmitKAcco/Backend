package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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
}
