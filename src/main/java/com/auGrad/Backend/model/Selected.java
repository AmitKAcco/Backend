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
@SequenceGenerator(name="seq15", initialValue=900,allocationSize = 1)
@Table(name="selected")
public class Selected {
    //PK
    @Id
    @Column(name="selected_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq15")
    private int selectedId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    @Column(name="emp_id")
    private int empId;

    @Column(name = "job_id")
    private int jobId;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")

    private List<Batch> batchesList;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")

    private List<Employee> employeeList;

    @ManyToMany(targetEntity = Job.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")

    private List<Job> jobList;


}
