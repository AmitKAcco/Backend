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

}
