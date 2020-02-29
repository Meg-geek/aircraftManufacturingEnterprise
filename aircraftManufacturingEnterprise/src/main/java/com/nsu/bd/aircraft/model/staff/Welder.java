package com.nsu.bd.aircraft.model.staff;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "welders")
public class Welder extends Worker {
    @Column(name = "brigade_id")
    private int brigadeId;
}
