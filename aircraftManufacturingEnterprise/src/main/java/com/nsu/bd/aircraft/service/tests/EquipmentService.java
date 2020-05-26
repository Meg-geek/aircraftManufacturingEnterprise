package com.nsu.bd.aircraft.service.tests;

import com.nsu.bd.aircraft.api.dto.tests.EquipmentDto;
import com.nsu.bd.aircraft.dao.tests.EquipmentDao;
import com.nsu.bd.aircraft.model.tests.Equipment;
import com.nsu.bd.aircraft.service.converters.tests.EquipmentConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentService {
    private final EquipmentDao equipmentDao;
    private final EquipmentConverter equipmentConverter;

    private final RangeService rangeService;

    @Transactional
    public void addEquipment(EquipmentDto equipmentDto) {
        equipmentDao.save(equipmentConverter.getEquipment(equipmentDto));
    }

    public void deleteById(int equipmentId) {
        equipmentDao.deleteById(equipmentId);
    }

    public List<EquipmentDto> getllEquipment() {
        return equipmentConverter.getEquipmentDtos(equipmentDao.findAll());
    }

    @Transactional
    public Equipment updateEquipment(EquipmentDto equipmentDto) {
        Equipment equipment = equipmentConverter.getEquipment(equipmentDto);
        equipment.setRange(rangeService.addRange(equipment.getRange()));
        return equipmentDao.save(equipment);
    }
}
