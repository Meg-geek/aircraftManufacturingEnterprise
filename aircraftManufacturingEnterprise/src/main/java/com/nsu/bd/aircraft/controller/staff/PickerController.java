package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.PickerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/pickers")
public class PickerController extends StaffController {
    private final PickerService pickerService;

    public PickerController(@Autowired PickerService pickerService) {
        super(pickerService);
        this.pickerService = pickerService;
    }


    @GetMapping("/get-without-brigade")
    public GeneralResponse<List<EmployeeDto>> getFreeWorkers() {
        return new GeneralResponse<>(pickerService.getFreeWorkers());
    }
}
