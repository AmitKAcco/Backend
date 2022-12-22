package com.auGrad.Backend.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
@Data
@Table(name="employee")
public class Employee {

    @Id
    @Column(name="emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name="batch_id")
    private int batchId;

    @Column(name="emp_name")
    private String empName;

    @Column(name="designation")
    private String designation;

    @Column(name="date_of_joining")
    private Date dateOfJoining;

    @Column(name="mob_no")
    private Long mobileNumber;

    @Column(name="email")
    private String email;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="delivery_director")
    private String deliveryDirector;

    @Column(name="blocked_id")
    private int blockedId;

    @Column(name="feedback_id")
    private int feedbackId;




}
