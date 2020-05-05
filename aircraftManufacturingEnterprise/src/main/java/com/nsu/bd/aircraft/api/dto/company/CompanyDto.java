package com.nsu.bd.aircraft.api.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private int id;
    private String name;

    public CompanyDto(String name) {
        this.name = name;
    }
}
