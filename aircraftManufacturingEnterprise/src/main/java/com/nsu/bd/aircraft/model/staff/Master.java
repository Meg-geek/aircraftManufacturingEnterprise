package com.nsu.bd.aircraft.model.staff;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "master")
public class Master extends EngineeringStaff {
    @Column(name = "site_id")
    private int siteId;
}
