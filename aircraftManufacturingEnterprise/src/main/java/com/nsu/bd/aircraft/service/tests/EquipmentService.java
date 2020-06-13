package com.nsu.bd.aircraft.service.tests;

import com.nsu.bd.aircraft.api.dto.tests.EquipmentDto;
import com.nsu.bd.aircraft.api.dto.tests.RangeDto;
import com.nsu.bd.aircraft.dao.tests.EquipmentDao;
import com.nsu.bd.aircraft.model.tests.Equipment;
import com.nsu.bd.aircraft.model.tests.Range;
import com.nsu.bd.aircraft.service.converters.tests.EquipmentConverter;
import com.nsu.bd.aircraft.service.converters.tests.RangeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentService {
    private final EquipmentDao equipmentDao;
    private final EquipmentConverter equipmentConverter;
    private final RangeConverter rangeConverter;

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
    public EquipmentDto updateEquipment(EquipmentDto equipmentDto) {
        Equipment equipment = equipmentConverter.getEquipment(equipmentDto);
        equipment.setRange(rangeService.addRange(equipment.getRange()));
        return equipmentConverter.getEquipmentDto(equipmentDao.save(equipment));
    }

    public List<EquipmentDto> getByProductAndRangeAndDateInterval(int productId,
                                                                  int rangeId,
                                                                  long beginDate,
                                                                  long endDate) {
        return equipmentConverter
                .getEquipmentDtos(equipmentDao
                        .getByProductAndRangeAndDateInterval(productId, rangeId,
                                new Date(beginDate), getEndDate(endDate)));
    }

    private Date getEndDate(long endDate) {
        if (endDate == 0) {
            return new Date(System.currentTimeMillis());
        }
        return new Date(endDate);
    }

    public List<EquipmentDto> getByRangeAndDateIntervalAndRocket(int rangeId,
                                                                 long beginDate,
                                                                 long endDate) {
        return equipmentConverter
                .getEquipmentDtos(equipmentDao
                        .getByRangeAndDateIntervalAndRocket(rangeId,
                                new Date(beginDate), getEndDate(endDate)));
    }

    public List<EquipmentDto> getByRangeAndDateIntervalAndPlane(int rangeId,
                                                                long beginDate,
                                                                long endDate) {
        return equipmentConverter
                .getEquipmentDtos(equipmentDao
                        .getByRangeAndDateIntervalAndPlane(rangeId,
                                new Date(beginDate), getEndDate(endDate)));
    }

    public List<EquipmentDto> getByRangeAndDateIntervalAndHelicopter(int rangeId,
                                                                     long beginDate,
                                                                     long endDate) {
        return equipmentConverter
                .getEquipmentDtos(equipmentDao
                        .getByRangeAndDateIntervalAndHelicopter(rangeId,
                                new Date(beginDate), getEndDate(endDate)));
    }

    public List<EquipmentDto> getByRangeAndDateIntervalAndHangGlider(int rangeId,
                                                                     long beginDate,
                                                                     long endDate) {
        return equipmentConverter
                .getEquipmentDtos(equipmentDao
                        .getByRangeAndDateIntervalAndHangGlider(rangeId,
                                new Date(beginDate), getEndDate(endDate)));
    }

    public List<EquipmentDto> getByRangeAndDateInterval(int rangeId,
                                                        long beginDate,
                                                        long endDate) {
        return equipmentConverter
                .getEquipmentDtos(equipmentDao
                        .getByRangeAndDateInterval(rangeId,
                                new Date(beginDate), getEndDate(endDate)));
    }

    public List<EquipmentDto> getByRange(RangeDto rangeDto) {
        Range range = rangeService.addRange(rangeConverter.getRange(rangeDto));
        List<Equipment> equipment = equipmentDao.findByRange(range);
        return equipmentConverter
                .getEquipmentDtos(equipment);
    }
}
