package com.nsu.bd.aircraft.model.tests;


import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.staff.Tester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name="range")
public class Range {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToMany
    private List<Guild> guilds;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "range_id")
    private List<Tester> testers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "range_id")
    private List<Equipment> equipments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "range_id")
    private List<Test> tests;
}
