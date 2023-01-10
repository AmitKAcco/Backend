package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Component
@Table(name = "ProjectTopics", uniqueConstraints = @UniqueConstraint(columnNames = {"projectName"}))
public class ProjectTopics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "batch_id")
    private int batchId; // FK
    @Column(name = "batchName")
    private String batchName;

//    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
//
//    private List<Batch> batchesList;
//
//    @ManyToMany(targetEntity = ProjectAssignments.class, cascade = CascadeType.ALL,mappedBy = "projectList")
//
//
//    private List<ProjectAssignments> projectAssignmentsList;
//
//    @ManyToMany(targetEntity = ProjectCalendar.class,cascade = CascadeType.ALL, mappedBy = "projectTopicsList")
//    private List<ProjectCalendar> projectCalendarList;




}