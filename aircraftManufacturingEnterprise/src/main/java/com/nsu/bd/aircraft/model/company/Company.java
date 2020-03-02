package com.nsu.bd.aircraft.model.company;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private List<Guild> guilds;

    protected Company() {
    }

    public Company(String name) {
        this.name = name;
    }
}
