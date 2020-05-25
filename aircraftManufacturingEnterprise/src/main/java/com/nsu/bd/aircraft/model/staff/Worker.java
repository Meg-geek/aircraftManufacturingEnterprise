package com.nsu.bd.aircraft.model.staff;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "worker")
@Inheritance(strategy = InheritanceType.JOINED)
public class Worker extends Employee {
    @ManyToOne
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;
}
