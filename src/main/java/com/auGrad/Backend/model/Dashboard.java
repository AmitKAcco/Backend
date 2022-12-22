package com.auGrad.Backend.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Component
@Table(name = "Dashboard")
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dashboard_id")
    private int dashboardId;
    @Column(name = "batch_id")
    private int batchId; //Foreign key
    @Column(name = "no_of_grads_placed")
    private int noOfGradsPlaced;
    @Column(name = "remaining_interviews")
    private int remainingInterviews;
    @Column(name = "totalGrads")
    private int totalGrads;




}
