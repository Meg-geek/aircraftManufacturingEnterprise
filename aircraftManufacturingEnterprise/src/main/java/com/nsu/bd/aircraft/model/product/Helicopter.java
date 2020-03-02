package com.nsu.bd.aircraft.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "helicopter")
public class Helicopter extends Product {
    private String type;
}
