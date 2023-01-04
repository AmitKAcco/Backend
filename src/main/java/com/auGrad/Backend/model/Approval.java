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
    @Column(name = "Approval_Id", unique = true)
    private int ApprovalId;
    @Column(name = "batchId")
    private int batchId;
    @Column(name = "techCalendar")
    private boolean techCalendar;
    @Column(name = "techCurriculum")
    private boolean techCurriculum;
}
