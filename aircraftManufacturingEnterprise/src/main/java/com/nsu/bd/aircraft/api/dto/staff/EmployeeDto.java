package com.nsu.bd.aircraft.api.dto.staff;

import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int id;
    private String name;
    private String surname;
    private BrigadeDto brigade;
    private SiteDto site;

    public EmployeeDto(String name) {
        this.name = name;
    }

    public EmployeeDto(int id, String name) {
        this(name);
        this.id = id;
    }
}
