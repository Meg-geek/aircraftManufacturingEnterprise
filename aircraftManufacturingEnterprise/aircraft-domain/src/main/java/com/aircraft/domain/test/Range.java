package com.aircraft.domain.test;

import com.aircraft.domain.company.Guild;
import com.aircraft.domain.staff.Tester;
import lombok.Getter;

import java.util.List;

@Getter
public class Range {
    private List<Guild> guilds;
    private List<Tester> testers;
    private List<Equipment> equipments;
}
