package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@Table(name="mentors")
public class Mentors {
    //PK
    @Id
    @Column(name="mentor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mentorId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    //FK
    @Column(name="emp_id")
    private int empId;

    @Column(name="grad_name")
    private String gradName;

    @Column(name="client_project_name")
    private String clientProjectName;

    @Column(name="stakeholder_name")
    private String stakeholderName;

    @Column(name="client")
    private String client;

}
