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
@SequenceGenerator(name="seq5", initialValue=500,allocationSize = 1)
@Table(name="training_calendar")
public class TrainingCalendar {
    //PK
    @Id
    @Column(name="trainingCalendar_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator="seq5")
    private int trainingCalendarId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    //FK
    @Column(name="topic_id")
    private int topicId;

    @Column(name="trainingTopic_name")
    private String trainingTopicName;

    @Column(name="trainingCalendar_date")
    private Date trainingCalendarDate;

    @Column(name="training_session")
    private String trainingSession;

    @Column(name="trainingCalendar_approve")
    private boolean trainingCalendarApprove;

    @OneToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;

    @OneToMany(targetEntity = TrainingCurriculum.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")

    private List<TrainingCurriculum> topicList;



}
