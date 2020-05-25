package com.nsu.bd.aircraft.api.dto.tests;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private int id;
    private EmployeeDto tester;
    private List<EquipmentDto> equipment;
    private GuildDto guild;
    private RangeDto range;
    private ProductDto product;
}
