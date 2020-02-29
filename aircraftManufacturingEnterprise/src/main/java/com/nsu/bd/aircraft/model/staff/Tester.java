package com.nsu.bd.aircraft.model.staff;

import com.nsu.bd.aircraft.model.tests.Test;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tester")
public class Tester extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tester_id")
    private List<Test> tests;
}
