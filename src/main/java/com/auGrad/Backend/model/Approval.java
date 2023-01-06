package com.auGrad.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Component
@Table(name = "Approval")
@SequenceGenerator(name="seq", initialValue=6000)
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Column(name = "Approval_Id")
    private int ApprovalId;
    @Column(name = "batchId")
    private int batchId;

    @Column(name = "batchName")
    private String batchName;
    @Column(name = "techCalendar")
    private Integer techCalendar;
    @Column(name = "techCurriculum")
    private Integer techCurriculum;
}
