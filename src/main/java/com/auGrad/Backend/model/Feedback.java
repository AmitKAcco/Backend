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
@SequenceGenerator(name="seq3", initialValue=3000,allocationSize = 1)
@Table(name="feedback")
public class Feedback {
    //PK
    @Id
    @Column(name="feedback_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq3")
    private int feedbackId;
    //FK
    @Column(name="batch_id")
    private int batchId;
    @Column(name = "batchName")
    private String batchName;

    //FK
    @Column(name="emp_id")
    private int empId;

    @Column(name="emp_name")
    private String empName;

    @Column(name="feedback_note")
    private String feedbackNote;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL,mappedBy = "feedbackList")
   //@JoinColumn(name = "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
    private List<Employee> employeeId;

}
