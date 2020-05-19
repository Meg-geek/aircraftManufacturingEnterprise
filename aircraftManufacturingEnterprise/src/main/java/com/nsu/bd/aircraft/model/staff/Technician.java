package com.nsu.bd.aircraft.model.staff;

import com.nsu.bd.aircraft.model.company.Site;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "technicians")
public class Technician extends EngineeringStaff {
    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;
}
