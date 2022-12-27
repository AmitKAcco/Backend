//Don't use it
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
@Table(name="project_progress")
public class ProjectProgress {
    //PK
    @Id
    @Column(name="projectProgress_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectProgressId;

    //FK
    @Column(name="batch_id")
    private int batchId;

    //FK
    @Column(name="project_id")
    private int projectId;

    @Column(name="projectProgress_status")
    private boolean projectProgressStatus;

    @OneToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id", insertable = false, updatable = false)

    private List<Batch> batchesList;

    @OneToMany(targetEntity = ProjectTopics.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", insertable = false, updatable = false)

    private List<Batch> projectList;

}
