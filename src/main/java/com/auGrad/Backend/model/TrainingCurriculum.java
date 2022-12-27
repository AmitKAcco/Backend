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
@Table(name="training_curriculum")
public class TrainingCurriculum {
    //PK
    @Id
    @Column(name="topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;


    @Column(name="topic_name")
    private String topicName;

    //FK
    @Column(name="batch_id")
    private int batchId;

    @OneToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;

}
