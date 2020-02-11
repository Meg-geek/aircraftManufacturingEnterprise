package com.aircraft.domain.company;

import com.aircraft.domain.staff.EngineeringStaff;
import com.aircraft.domain.test.Range;
import lombok.Getter;

import java.util.List;

@Getter
public class Guild {
    private EngineeringStaff guildManager;
    private List<Range> ranges;
}
