package com.nsu.bd.aircraft.model.tests;


import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.staff.Tester;
import lombok.Getter;

import java.util.List;

@Getter
public class Range {
    private List<Guild> guilds;
    private List<Tester> testers;
    private List<Equipment> equipments;
}
