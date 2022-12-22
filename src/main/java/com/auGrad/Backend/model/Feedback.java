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
@Table(name="feedback")
public class Feedback {
    //PK
    @Id
    @Column(name="feedback_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;
    //FK
    @Column(name="batch_id")
    private int batchId;

    //FK
    @Column(name="emp_id")
    private int empId;

    @Column(name="feedback_note")
    private String feedbackNote;

    @OneToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;

    @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")

    private List<Employee> employeeList;

}
