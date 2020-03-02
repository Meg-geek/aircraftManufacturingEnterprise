package com.nsu.bd.aircraft.model.staff;

import com.nsu.bd.aircraft.model.tests.Test;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "tester")
public class Tester extends Employee {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tester_id")
    private List<Test> tests;
}
