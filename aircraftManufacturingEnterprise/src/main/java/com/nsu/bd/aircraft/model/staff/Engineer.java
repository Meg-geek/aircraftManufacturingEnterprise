package com.nsu.bd.aircraft.model.staff;

import com.nsu.bd.aircraft.model.company.Site;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "engineers")
public class Engineer extends EngineeringStaff {
    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;
}
