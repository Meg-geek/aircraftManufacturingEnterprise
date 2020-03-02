package com.nsu.bd.aircraft.model.staff;

import com.nsu.bd.aircraft.model.company.Site;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity(name = "master")
public class Master extends EngineeringStaff {
    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;
}
