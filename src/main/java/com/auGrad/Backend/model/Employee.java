//package com.auGrad.Backend.model;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Component
//@Getter
//@Setter
//@SequenceGenerator(name="seq1", initialValue=8000,allocationSize=1)
//@Table(name="employee")
//public class Employee {
//    //PK
//    @Id
//    @Column(name="emp_id")
//    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq1")
//    private int empId;
//
//    //FK
//    @Column(name="batch_id")
//    private int batchId;
//
//    @Column(name="employee_name")
//    private String employeeName;
//
//    @Column(name="designation")
//    private String designation;
//
//    @Column(name="date_of_joining")
//    private Date dateOfJoining;
//
//    @Column(name="mob_no")
//    private Long mobileNumber;
//
//    @Column(name="email")
//    private String email;
//
//    @Column(name="date_of_birth")
//    private Date dateOfBirth;
//
//    @Column(name="delivery_director")
//    private String deliveryDirector;
//    //FK
//    @Column(name="blocked_id")
//    private int blockedId;
//    //FK
//    @Column(name="feedback_id")
//    private int feedbackId;
//
//    @ManyToOne(targetEntity = Batch.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)
//
//    private Batch batchesList;
//
//    @OneToMany(targetEntity = Blocked.class, cascade = CascadeType.ALL,mappedBy = "employeeId")
//    //@JoinColumn(name = "blocked_id", referencedColumnName = "blocked_id", insertable = false, updatable = false)
//
//    private List<Blocked> blockedList;
//
//
////    @ManyTo(targetEntity = Blocked.class, cascade = CascadeType.ALL)
////    @JoinColumn(name = "blocked_id", referencedColumnName = "blocked_id", insertable = false, updatable = false)
////
////    private List<Batch> blockedList;
//
//
//    @ManyToMany(targetEntity = Feedback.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "feedback_id", referencedColumnName = "feedback_id", insertable = false, updatable = false)
//
//    private List<Feedback> feedbackList;
//
//    @ManyToMany(targetEntity = ProjectAssignments.class, cascade = CascadeType.ALL,mappedBy = "employeeList")
//
//
//    private List<ProjectAssignments> projectAssignmentsList;
//
//
//
//
//
//}
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
@SequenceGenerator(name="seq1", initialValue=8000,allocationSize=1)
@Table(name="employee", uniqueConstraints = @UniqueConstraint(columnNames = {"mob_no","email"}))
public class Employee {
    //PK
    @Id
    @Column(name="emp_id")

 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    @Column(name = "batchName")
    private String batchName;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="designation")
    private String designation;

    @Column(name="date_of_joining")
    private Date dateOfJoining;

    @Column(name="mob_no")
    private Long mobileNumber;

    @Column(name="email")
    private String email;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

   @Column(name = "gender")
   private String gender;

   @Column(name="delivery_director")
    private String deliveryDirector;
    //FK
//    @Column(name="blocked_id")
//    private int blockedId;
//    //FK
//    @Column(name="feedback_id")
//    private int feedbackId;

//   @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
//   @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)
//
//   private List<Batch> batchesList;
//
//   @ManyToMany(targetEntity = Blocked.class, cascade = CascadeType.ALL,mappedBy = "employeeList")
////@JoinColumn(name = "blocked_id", referencedColumnName = "blocked_id", insertable = false, updatable = false)
//
//
//   private List<Blocked> blockedList;
//
//
////    @ManyTo(targetEntity = Blocked.class, cascade = CascadeType.ALL)
////    @JoinColumn(name = "blocked_id", referencedColumnName = "blocked_id", insertable = false, updatable = false)
////
////    private List<Batch> blockedList;
//
//
//    @ManyToMany(targetEntity = Feedback.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "feedback_id", referencedColumnName = "feedback_id", insertable = false, updatable = false)
//
//    private List<Feedback> feedbackList;
//
//    @ManyToMany(targetEntity = TrainerAssigned.class,cascade = CascadeType.ALL, mappedBy = "employeeList")
//    private List<TrainerAssigned> trainerAssignedList;
//
//    @ManyToMany(targetEntity = ProjectAssignments.class,cascade = CascadeType.ALL, mappedBy = "employeeList")
//    private List<ProjectAssignments> projectAssignmentList;
//
//    @ManyToMany(targetEntity = MockInterview.class,cascade = CascadeType.ALL, mappedBy = "employeeList")
//    private List<MockInterview> mockInterviewList;
//
//
//@ManyToMany(targetEntity = Interview.class,cascade = CascadeType.ALL, mappedBy = "employeeList")
//    private List<Interview> interviewList;
//
//    @ManyToMany(targetEntity = CheckBlocked.class,cascade = CascadeType.ALL, mappedBy = "employeeList")
//    private List<CheckBlocked> checkBlockedList;
//
////    @ManyToMany(targetEntity = Mentors.class,cascade = CascadeType.ALL, mappedBy = "employeeList")
////    private List<TrainerAssigned> trainerAssignedList;
//
//    @ManyToMany(targetEntity = Selected.class,cascade = CascadeType.ALL, mappedBy = "employeeList")
//    private List<Selected> selectedListList;

}

