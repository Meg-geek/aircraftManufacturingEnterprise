package com.nsu.bd.aircraft.api.dto.staff;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GuildManagerDto extends EmployeeDto {
    public GuildManagerDto(int id, String name, String surname) {
        super(id, name, surname);
    }

    public GuildManagerDto(int id, String name) {
        super(id, name);
    }

    public GuildManagerDto(String name) {
        super(name);
    }
}
