package com.aircraft.domain.company;

import com.aircraft.domain.staff.Brigade;
import com.aircraft.domain.staff.Engineer;
import com.aircraft.domain.staff.EngineeringStaff;
import lombok.Getter;

import java.util.List;

@Getter
public class Site {
    private String workType;
    private EngineeringStaff siteManager;
    private List<EngineeringStaff> masters;
    private List<Brigade> brigades;
}
