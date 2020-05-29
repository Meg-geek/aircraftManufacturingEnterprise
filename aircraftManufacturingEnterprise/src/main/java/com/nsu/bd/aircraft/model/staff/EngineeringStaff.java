package com.nsu.bd.aircraft.model.staff;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class EngineeringStaff extends Employee {
    public EngineeringStaff(int id, String name, String surname) {
        super(id, name, surname);
    }
}
