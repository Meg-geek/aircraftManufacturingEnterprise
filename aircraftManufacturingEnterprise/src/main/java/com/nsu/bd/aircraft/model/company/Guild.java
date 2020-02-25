package com.nsu.bd.aircraft.model.company;


import com.nsu.bd.aircraft.model.staff.EngineeringStaff;
import com.nsu.bd.aircraft.model.tests.Range;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Guild {
    private int id, companyId;

    private EngineeringStaff guildManager;
    private List<Range> ranges;
}
