package com.nsu.bd.aircraft.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity(name = "plane")
public class Plane extends Product {
    private String type;

    @Column(name = "engine_amount")
    private int engineAmount;
}
