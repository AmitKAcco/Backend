package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@Table(name="buddy")
public class Buddy {
    //PK
    @Id
    @Column(name="buddy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buddyId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    //FK
    @Column(name="emp_id")
    private int empId;

    @Column(name="grad_name")
    private String gradName;

    @Column(name="buddy_name")
    private String buddyName;

}
