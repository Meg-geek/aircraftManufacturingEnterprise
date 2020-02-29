package com.nsu.bd.aircraft.model.product;
/*
дельтоплан
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "hang_glider")
public class HangGlider extends Product{
    private String type;
}
