package com.nsu.bd.aircraft.api.dto.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    protected int id;
    protected String name;
    protected String surname;

    public EmployeeDto(String name) {
        this.name = name;
    }

    public EmployeeDto(int id, String name) {
        this(name);
        this.id = id;
    }
}
