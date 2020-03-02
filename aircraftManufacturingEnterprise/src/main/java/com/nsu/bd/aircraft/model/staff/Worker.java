package com.nsu.bd.aircraft.model.staff;

import javax.persistence.*;

@Entity(name = "worker")
@Inheritance(strategy = InheritanceType.JOINED)
public class Worker extends Employee {
    @ManyToOne
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;
}
