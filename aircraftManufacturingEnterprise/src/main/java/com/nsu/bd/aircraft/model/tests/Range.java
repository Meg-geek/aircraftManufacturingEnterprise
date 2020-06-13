package com.nsu.bd.aircraft.model.tests;


import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.staff.Tester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "range")
public class Range {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "range_id_seq")
    @SequenceGenerator(name = "range_id_seq", sequenceName = "range_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "range_guild",
            joinColumns = @JoinColumn(name = "range_id"),
            inverseJoinColumns = @JoinColumn(name = "guild_id"))
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
