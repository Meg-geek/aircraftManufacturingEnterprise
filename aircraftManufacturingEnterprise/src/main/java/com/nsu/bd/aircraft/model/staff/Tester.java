package com.nsu.bd.aircraft.model.staff;

import com.nsu.bd.aircraft.model.tests.Range;
import com.nsu.bd.aircraft.model.tests.Test;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "tester")
public class Tester extends Employee {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tester_id")
    private List<Test> tests;

    @ManyToOne
    @JoinColumn(name = "range_id")
    private Range range;
}
