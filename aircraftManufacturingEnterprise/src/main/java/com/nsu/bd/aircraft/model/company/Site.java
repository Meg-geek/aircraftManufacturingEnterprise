package com.nsu.bd.aircraft.model.company;


import com.nsu.bd.aircraft.model.staff.Brigade;
import com.nsu.bd.aircraft.model.staff.EngineeringStaff;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class Site {
    private int id, guildId;
    private String workType;
    private EngineeringStaff siteManager;
    private List<EngineeringStaff> masters;
    private List<Brigade> brigades;
}
