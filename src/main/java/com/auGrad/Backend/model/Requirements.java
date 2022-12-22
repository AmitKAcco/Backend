package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Component
@Table(name = "Requirements")
public class Requirements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requirement_id")
    private int requirementId;
    @Column(name = "batch_id")
    private int batchId; // Foreign Key
    @Column(name = "no_of_positions")
    private int noOfPositions;
    @Column(name = "stakeholder")
    private String stakeholder;
    @Column(name = "department")
    private String department;
    @Column(name = "location")
    private String location;
    @Column(name = "clients")
    private String clients;
    @Column(name = "gender")
    private String gender;
}
