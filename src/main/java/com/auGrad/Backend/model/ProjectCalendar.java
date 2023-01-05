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

    @Column(name = "teamNumber")
    private String teamNumber;

    @Column(name = "project_Progress")
    private String projectProgress;

    @Column(name = "project_name")
    private String projectName;





//    @Column(name = "approve")
//    private boolean approve;

    @Column(name = "batch_id")
    private int batchId; // Foreign Key
    @Column(name = "batchName")
    private String batchName;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;
    @ManyToMany(targetEntity = ProjectAssignments.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "teamNumber", referencedColumnName = "teamNumber")

    private List<ProjectAssignments> teamNumberList;

    @ManyToMany(targetEntity = ProjectTopics.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_name", referencedColumnName = "project_name")

    private List<ProjectTopics> projectTopicsList;

}
