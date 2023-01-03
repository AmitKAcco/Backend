package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@Getter
@Setter
//@SequenceGenerator(name="seq5", initialValue=500,allocationSize = 1)
@Table(name="training_curriculum")
public class TrainingCurriculum {
    //PK
    @Id
    @Column(name="topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY /*generator="seq5"*/)
    private int topicId;


    @Column(name="topic_name")
    private String topicName;

    //FK
    @Column(name="batch_id")
    private int batchId;

    @Column(name = "approve")
    private boolean approve;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;

//    @ManyToOne(targetEntity = TrainingCalendar.class, cascade = CascadeType.ALL)
//    //@JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
//
//    private TrainingCalendar trainingCalendarList;
@ManyToMany(targetEntity = TrainingCalendar.class, cascade = CascadeType.ALL,mappedBy = "topicList")


private List<TrainingCalendar> trainingCalendarList;


    @ManyToMany(targetEntity = Evaluation.class, cascade = CascadeType.ALL,mappedBy = "topicList")
    private List<Evaluation> evaluationList;


    @ManyToMany(targetEntity = TrainerAssigned.class, cascade = CascadeType.ALL,mappedBy = "topicList")
    private List<TrainerAssigned> trainerAssignedList;
}
