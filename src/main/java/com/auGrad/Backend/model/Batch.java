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
//@Table(name = "batch",uniqueConstraints={@UniqueConstraint(columnNames={"batchName"})})
@Table(name = "batch", uniqueConstraints = @UniqueConstraint(columnNames = {"batchName"}))
@SequenceGenerator(name="seqbatch", initialValue=5000 ,allocationSize = 1)
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqbatch")
    @Column(name = "batch_id")
    private int batchId;
    @Column(name = "batchName")
    private String batchName;
//    @Column(name = "vertical")
//    private String vertical;

    //    @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
//
////    private List<Employee> employeeList;
////
//    @ManyToMany(targetEntity = Employee.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<Employee> employeeList;
//
//
//    @ManyToMany(targetEntity = TrainingCurriculum.class, cascade = CascadeType.ALL,mappedBy = "batchesList")
//    private List<TrainingCurriculum> trainingCurriculumList;
//
//    @ManyToMany(targetEntity = TrainingCalendar.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<TrainingCalendar> trainingCalendarList;
//
//
//    @ManyToMany(targetEntity = ProjectAssignments.class, cascade = CascadeType.ALL,mappedBy = "batchesList")
//    private List<ProjectAssignments> projectAssignmentsList;
//
//    @ManyToMany(targetEntity = Evaluation.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<Evaluation> evaluationList;
//
//    @ManyToMany(targetEntity = TrainerAssigned.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<TrainerAssigned> trainerAssignedList;
//
//    @ManyToMany(targetEntity = Requirements.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<Requirements> requirementList;
//
//    @ManyToMany(targetEntity = ProjectTopics.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<ProjectTopics> projectTopicList;
//
//    @ManyToMany(targetEntity = ProjectCalendar.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<ProjectCalendar> projectCalendarList;
//
//    @ManyToMany(targetEntity = MockInterview.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<MockInterview> mockInterviewList;
//
//    @ManyToMany(targetEntity = Buddy.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<Buddy> buddyList;
//
//    @ManyToMany(targetEntity = Blocked.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<Blocked> blockedList;
//
//    @ManyToMany(targetEntity = Dashboard.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<Dashboard> dashboardList;
//
//    @ManyToMany(targetEntity = Interview.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<Interview> interviewList;
//
//    @ManyToMany(targetEntity = CheckBlocked.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<CheckBlocked> checkBlockedList;
//
//    @ManyToMany(targetEntity = Selected.class,cascade = CascadeType.ALL, mappedBy = "batchesList")
//    private List<Selected> selectedList;


}
