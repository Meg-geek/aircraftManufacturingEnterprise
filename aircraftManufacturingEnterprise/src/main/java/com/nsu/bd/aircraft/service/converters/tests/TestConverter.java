package com.nsu.bd.aircraft.service.converters.tests;

import com.nsu.bd.aircraft.api.dto.tests.TestDto;
import com.nsu.bd.aircraft.model.tests.Test;
import com.nsu.bd.aircraft.service.converters.company.GuildConverter;
import com.nsu.bd.aircraft.service.converters.product.ProductConverter;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestConverter {
    private final EmployeeConverter employeeConverter;
    private final EquipmentConverter equipmentConverter;
    private final GuildConverter guildConverter;
    private final RangeConverter rangeConverter;
    private final ProductConverter productConverter;

    public TestDto getTestDto(Test test) {
        if (test == null) {
            return null;
        }
        TestDto testDto = new TestDto();
        testDto.setId(test.getId());
        testDto.setTester(employeeConverter.getEmployeeDto(test.getTester()));
        testDto.setEquipment(equipmentConverter
                .getEquipmentDtos(test.getEquipment()));
        testDto.setGuild(guildConverter
                .getGuildDto(test.getGuild()));
        testDto.setRange(rangeConverter
                .getRangeDto(test.getRange()));
        testDto.setProduct(productConverter.getProductDto(test.getProduct()));
        return testDto;
    }

    public Test getTest(TestDto testDto) {
        if (testDto == null) {
            return null;
        }
        Test test = new Test();
        test.setId(testDto.getId());
        test.setTester(employeeConverter
                .getTester(testDto.getTester()));
        test.setEquipment(equipmentConverter
                .getEquipmentList(testDto.getEquipment()));
        test.setGuild(guildConverter
                .getGuild(testDto.getGuild()));
        test.setRange(rangeConverter
                .getRange(testDto.getRange()));
        test.setProduct(productConverter
                .getProduct(testDto.getProduct()));
        return test;
    }

    public List<TestDto> getTestDtos(List<Test> tests) {
        if (tests == null) {
            return emptyList();
        }
        return tests.stream()
                .map(this::getTestDto)
                .collect(toList());
    }
}
