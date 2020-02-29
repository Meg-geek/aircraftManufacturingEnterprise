package com.nsu.bd.aircraft.model.staff;

import javax.persistence.*;

@Entity(name = "site_manager")
public class SiteManager extends EngineeringStaff {
    @Id
    @Column(name = "id_pk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPk;
}
