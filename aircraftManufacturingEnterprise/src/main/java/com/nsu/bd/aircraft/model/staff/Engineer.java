package com.nsu.bd.aircraft.model.staff;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "engineers")
public class Engineer extends EngineeringStaff {
    @Column(name = "site_id")
    private int siteId;
}
