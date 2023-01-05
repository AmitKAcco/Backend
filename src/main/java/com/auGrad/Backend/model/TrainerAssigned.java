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
    @Column(name = "batchName")
    private String batchName;

    //FK
    @Column(name="topic_id")
    private int topicId;

    @Column(name="topic_name")
    private String topicName;

//
//    @Column(name="emp_id")
//    private int empId;


//    @Column(name="grad_name")
//    private String gradName;

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

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;


    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")

    private List<Employee> employeeList;


    @ManyToMany(targetEntity = TrainingCurriculum.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")

    private List<TrainingCurriculum> topicList;

}
