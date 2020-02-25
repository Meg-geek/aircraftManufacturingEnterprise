package com.nsu.bd.aircraft.model.staff;

import lombok.Getter;

import java.util.List;

@Getter
public class Brigade {
    private Worker foreman;
    private List<Worker> workers;
}