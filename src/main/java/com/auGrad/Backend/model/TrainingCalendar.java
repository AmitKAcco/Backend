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
@Table(name="training_curriculum")
public class TrainingCalendar {
    //PK
    @Id
    @Column(name="trainingCalendar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Date trainingCalendar_date;

    @Column(name="training_session")
    private String trainingSession;

    @Column(name="trainingCalendar_approve")
    private boolean trainingCalendarApprove;



}
