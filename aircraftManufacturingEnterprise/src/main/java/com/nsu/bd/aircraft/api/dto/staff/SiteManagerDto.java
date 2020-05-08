package com.nsu.bd.aircraft.api.dto.staff;

public class SiteManagerDto extends EmployeeDto {
    public SiteManagerDto(int id, String name, String surname) {
        super(id, name, surname);
    }

    public SiteManagerDto(int id, String name) {
        super(id, name);
    }

    public SiteManagerDto(String name) {
        super(name);
    }
}
