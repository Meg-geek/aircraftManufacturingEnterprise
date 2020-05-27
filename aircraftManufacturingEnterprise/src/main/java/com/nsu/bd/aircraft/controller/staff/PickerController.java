package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.PickerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/pickers")
public class PickerController extends StaffController {
    private final PickerService pickerService;

    public PickerController(@Autowired PickerService pickerService) {
        super(pickerService);
        this.pickerService = pickerService;
    }
}
