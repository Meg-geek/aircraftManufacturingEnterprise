package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.StaffService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
public class StaffController {
    private StaffService staffService;

    StaffController(@Autowired StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<EmployeeDto>> getAll() {
        return new GeneralResponse<>(staffService.getAll());
    }

    @PostMapping("/add")
    public GeneralResponse<?> add(@RequestBody EmployeeDto employeeDto) {
        staffService.add(employeeDto);
        return GeneralResponse.ok();
    }

    @DeleteMapping("/delete-by-id")
    public void deleteById(@RequestParam("masterId") int masterId) {
        staffService.deleteById(masterId);
    }

    @PutMapping("/update")
    public GeneralResponse<EmployeeDto> update(@RequestBody EmployeeDto employeeDto) {
        return new GeneralResponse<>(staffService.update(employeeDto));
    }

    @GetMapping("/get-by-company")
    public GeneralResponse<List<EmployeeDto>> getByCompany(
            @RequestParam("companyId") int companyId) {
        return new GeneralResponse<>(staffService.getByCompany(companyId));
    }

    @GetMapping("/get-by-guild")
    public GeneralResponse<List<EmployeeDto>> getByGuild(
            @RequestParam("guildId") int guildId) {
        return new GeneralResponse<>(staffService.getByGuild(guildId));
    }
}
