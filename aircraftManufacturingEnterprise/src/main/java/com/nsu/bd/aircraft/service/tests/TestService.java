package com.nsu.bd.aircraft.service.tests;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.api.dto.tests.TestDto;
import com.nsu.bd.aircraft.dao.tests.TestDao;
import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.tests.Test;
import com.nsu.bd.aircraft.service.company.GuildService;
import com.nsu.bd.aircraft.service.converters.company.GuildConverter;
import com.nsu.bd.aircraft.service.converters.tests.TestConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestService {
    private final TestDao testDao;
    private final TestConverter testConverter;
    private final GuildConverter guildConverter;
    private final GuildService guildService;

    @Transactional
    public void addTest(TestDto testDto) {
        testDao.save(testConverter.getTest(testDto));
    }

    public List<TestDto> getAllTests() {
        return testConverter.getTestDtos(testDao.findAll());
    }

    @Transactional
    public void deleteById(int testId) {
        testDao.deleteById(testId);
    }

    @Transactional
    public TestDto updateTest(TestDto testDto) {
        return testConverter
                .getTestDto(testDao
                        .save(testConverter
                                .getTest(testDto)));
    }

    public List<TestDto> findByGuild(GuildDto guildDto) {
        Guild guild = guildService.addGuild(guildConverter.getGuild(guildDto));
        return testConverter
                .getTestDtos(testDao
                        .findByGuild(guild));
    }

    public Test addTest(Test test) {
        return testDao.save(test);
    }
}
