package com.nsu.bd.aircraft.model.accounting;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "stage")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "stage_name")
    private String stageName;

    protected Stage() {
    }

    public Stage(String stageName) {
        this.stageName = stageName;
    }
}
