package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
@Getter
@Setter
@Table(name="trainer_assigned")
public class TrainerAssigned {

    //PK
    @Id
    @Column(name="trainerAssigned_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainerAssignedId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    //FK
    @Column(name="topic_id")
    private int topicId;

    @Column(name="topic_name")
    private String topicName;

    //FK
    @Column(name="emp_id")
    private int empId;

    @Column(name="grad_name")
    private String gradName;

    @Column(name="trainer_name1")
    private String trainerName1;

    @Column(name="trainer_name2")
    private String trainerName2;

    @Column(name="training_date")
    private Date training_date;

    @Column(name="training_session")
    private String training_session;

    @Column(name="training_objective")
    private String trainingObjective;





}
