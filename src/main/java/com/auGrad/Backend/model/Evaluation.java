package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Component
@Table(name = "Evaluation")
public class Evaluation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eval_id")
    private int evalId;

    @Column(name = "batch_id")
    private int batchId; // foreign Key
    @Column(name = "emp_id")
    private int empId; // foreign Key

    @Column(name = "topic_id")
    private int topicId; // foreign Key

    @Column(name = "date")
    private Date date;

    @Column(name = "score")
    private int score;

    @Column(name = "feedback")
    private String feedback;


}
