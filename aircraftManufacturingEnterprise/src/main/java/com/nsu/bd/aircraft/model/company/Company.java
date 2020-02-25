package com.nsu.bd.aircraft.model.company;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Company {
    private int id;
    private String name;
    private List<Guild> guilds;
}
