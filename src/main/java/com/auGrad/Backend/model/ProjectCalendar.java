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
@Table(name = "ProjectCalendar")
public class ProjectCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectCalendar_id")
    private int projectCalendarId;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "approve")
    private boolean approve;

    @Column(name = "batch_id")
    private int batchId; // Foreign Key

}
