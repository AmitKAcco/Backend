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
@Table(name="buddy")
public class Buddy {
    //PK
    @Id
    @Column(name="buddyTable_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buddyTableId;

    //FK
    @Column(name="batch_id")
    private int batchId;
    @Column(name = "batchName")
    private String batchName;

    //FK
    @Column(name="grad_id")
    private int gradId;

    @Column(name="buddy_id")
    private int buddyId;

    @Column(name="grad_name")
    private String gradName;

    @Column(name="buddy_name")
    private String buddyName;

    @ManyToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)

    private List<Employee> employeeList;

}
