package com.nsu.bd.aircraft.service.converters.tests;

import com.nsu.bd.aircraft.api.dto.tests.EquipmentDto;
import com.nsu.bd.aircraft.model.tests.Equipment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentConverter {
    private final RangeConverter rangeConverter;

    public Equipment getEquipment(EquipmentDto equipmentDto) {
        if (equipmentDto == null) {
            return null;
        }
        Equipment equipment = new Equipment();
        equipment.setId(equipmentDto.getId());
        equipment.setType(equipmentDto.getType());
        return equipment;
    }

    public EquipmentDto getEquipmentDto(Equipment equipment) {
        if (equipment == null) {
            return null;
        }
        return new EquipmentDto(equipment.getId(),
                equipment.getType(),
                rangeConverter.getRangeDto(equipment.getRange()));
    }

    public List<EquipmentDto> getEquipmentDtos(List<Equipment> equipmentList) {
        if (equipmentList == null) {
            return emptyList();
        }
        return equipmentList.stream()
                .map(this::getEquipmentDto)
                .collect(toList());
    }

    public List<Equipment> getEquipmentList(List<EquipmentDto> equipmentDtos) {
        if (equipmentDtos == null) {
            return emptyList();
        }
        return equipmentDtos.stream()
                .map(this::getEquipment)
                .collect(toList());
    }
}
