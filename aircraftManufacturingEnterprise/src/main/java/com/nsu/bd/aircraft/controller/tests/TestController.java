package com.nsu.bd.aircraft.controller.tests;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.api.dto.tests.TestDto;
import com.nsu.bd.aircraft.service.tests.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/tests/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final TestService testService;

    @GetMapping("/get-all")
    public GeneralResponse<List<TestDto>> getAllTests() {
        return new GeneralResponse<>(testService.getAllTests());
    }

    @PostMapping("/add")
    public GeneralResponse<?> addTest(@RequestBody TestDto testDto) {
        testService.addTest(testDto);
        return GeneralResponse.ok();
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<?> deleteById(@RequestParam("id") int testId) {
        testService.deleteById(testId);
        return GeneralResponse.ok();
    }

    @PutMapping("/update")
    public GeneralResponse<TestDto> updateTest(@RequestBody TestDto testDto) {
        return new GeneralResponse<>(testService.updateTest(testDto));
    }

    @PutMapping("/get-by-guild")
    public GeneralResponse<List<TestDto>> getByGuild(@RequestBody GuildDto guildDto) {
        return new GeneralResponse<>(testService.findByGuild(guildDto));
    }
}
