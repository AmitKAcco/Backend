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
@Table(name = "batch")
@SequenceGenerator(name="seq", initialValue=6000)
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Column(name = "batch_id")
    private int batchId;
    @Column(name = "batchName")
    private String batchName;
    @Column(name = "vertical")
    private String vertical;

    //    @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
//
//    private List<Employee> employeeList;
//

@ManyToMany(targetEntity = TrainingCurriculum.class, cascade = CascadeType.ALL,mappedBy = "batchesList")
private List<TrainingCurriculum> trainingCurriculumList;

@ManyToMany(targetEntity = TrainingCalendar.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
    private List<TrainingCalendar> trainingCalendarList;


    @ManyToMany(targetEntity = ProjectAssignments.class, cascade = CascadeType.ALL,mappedBy = "batchesList")
    private List<ProjectAssignments> projectAssignmentsList;

    @ManyToMany(targetEntity = Evaluation.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
    private List<Evaluation> evaluationList;

    @ManyToMany(targetEntity = TrainerAssigned.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
    private List<TrainerAssigned> trainerAssignedList;

    @ManyToMany(targetEntity = Requirements.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
    private List<Requirements> requirementList;

    @ManyToMany(targetEntity = ProjectTopics.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
    private List<ProjectTopics> projectTopicList;

    @ManyToMany(targetEntity = ProjectCalendar.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
    private List<ProjectCalendar> projectCalendarList;

    @ManyToMany(targetEntity = MockInterview.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
    private List<MockInterview> mockInterviewList;







}
