package com.nsu.bd.aircraft.api.dto.tests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto {
    private int id;
    private String type;
    private RangeDto range;
}
