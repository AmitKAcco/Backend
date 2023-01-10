package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(name = "batchName")
    private String batchName;
    @Column(name = "emp_id")
    private int empId; // foreign Key

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "topic_id")
    private int topicId; // foreign Key

    @Column(name = "topic_name")
    private String topicName;
    @Column(name = "date")
    private Date date;

    @Column(name = "score")
    private int score;

    @Column(name = "feedback")
    private String feedback;

//    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
//
//    private List<Batch> batchesList;
//
//    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
//
//    private List<Employee> employeeList;
//
//    @ManyToMany(targetEntity = TrainingCurriculum.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
//
//    private List<TrainingCurriculum> topicList;



}
