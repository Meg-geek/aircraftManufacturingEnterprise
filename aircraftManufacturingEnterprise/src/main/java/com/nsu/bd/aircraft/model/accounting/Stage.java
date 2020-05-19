package com.nsu.bd.aircraft.model.accounting;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "stage")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stage_id_seq")
    @SequenceGenerator(name = "stage_id_seq", sequenceName = "stage_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "stage_name")
    private String stageName;

    protected Stage() {
    }

    public Stage(String stageName) {
        this.stageName = stageName;
    }
}
