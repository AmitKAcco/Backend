package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Component
@Getter
@Setter
@Table(name="employee")
public class Employee {
    //PK
    @Id
    @Column(name="emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    @Column(name="employee_name")
    private String employeeName;

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
    //FK
    @Column(name="blocked_id")
    private int blockedId;
    //FK
    @Column(name="feedback_id")
    private int feedbackId;

    @OneToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;

    @OneToMany(targetEntity = Blocked.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "blocked_id", referencedColumnName = "blocked_id")

    private List<Batch> blockedList;

    @OneToMany(targetEntity = Feedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id", referencedColumnName = "feedback_id")

    private List<Batch> feedbackList;





}
