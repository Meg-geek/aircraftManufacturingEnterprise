package com.nsu.bd.aircraft.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "rocket")
public class Rocket extends Product {
    private String type;

    @Column(name = "charge_power")
    private int chargePower;
}
