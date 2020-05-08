package com.nsu.bd.aircraft.model.staff;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class EngineeringStaff extends Employee {
    public EngineeringStaff(int id, String name, String surname) {
        super(id, name, surname);
    }
}
