package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@Table(name="feedback")
public class Feedback {
    //PK
    @Id
    @Column(name="feedback_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;
    //FK
    @Column(name="batch_id")
    private int batchId;

    //FK
    @Column(name="emp_id")
    private int empId;

    @Column(name="feedback_note")
    private String feedbackNote;
}
