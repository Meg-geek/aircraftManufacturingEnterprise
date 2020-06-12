package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.BrigadeDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.BrigadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/brigades")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BrigadeController {
    private final BrigadeService brigadeService;

    @PostMapping("/add")
    public GeneralResponse<BrigadeDto> addBrigade(@RequestBody BrigadeDto brigadeDto) {
        return new GeneralResponse<>(brigadeService.addBrigade(brigadeDto));
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<BrigadeDto>> getAllBrigades() {
        return new GeneralResponse<>(brigadeService.getAllBrigades());
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse deleteById(@RequestParam("id") int id) {
        brigadeService.deleteById(id);
        return GeneralResponse.ok();
    }

    @PutMapping("/update")
    public GeneralResponse<BrigadeDto> updateBrigade(@RequestBody BrigadeDto brigadeDto) {
        return new GeneralResponse<>(brigadeService.updateBrigade(brigadeDto));
    }

    @GetMapping("/get-by-site-id")
    public GeneralResponse<List<BrigadeDto>> getBrigadesBySiteId(
            @RequestParam("siteId") int siteId) {
        return new GeneralResponse<>(brigadeService.getBrigadesBySiteId(siteId));
    }

    @GetMapping("/get-by-guild-id")
    public GeneralResponse<List<BrigadeDto>> getBrigadesByGuildId(
            @RequestParam("guildId") int guildId) {
        return new GeneralResponse<>(brigadeService.getBrigadesByGuildId(guildId));
    }

    @GetMapping("/get-by-product-id")
    public GeneralResponse<List<BrigadeDto>> getBrigadesByProductId(
            @RequestParam("productId") int productId) {
        return new GeneralResponse<>(brigadeService.getBrigadesByProductId(productId));
    }

    @PutMapping("/set-site")
    public GeneralResponse setSite(
            @RequestParam("brigadeId") int brigadeId,
            @RequestParam("siteId") int siteId) {
        brigadeService.setSite(brigadeId, siteId);
        return GeneralResponse.ok();
    }

    @PutMapping("/set-foreman")
    public GeneralResponse setForeman(
            @RequestParam("brigadeId") int brigadeId,
            @RequestParam("staffId") int staffId) {
        brigadeService.setForeman(brigadeId, staffId);
        return GeneralResponse.ok();
    }

    @GetMapping("/get-foreman")
    public GeneralResponse<EmployeeDto> getForeman(
            @RequestParam("brigadeId") int brigadeId) {
        return new GeneralResponse<>(brigadeService.getForeman(brigadeId));
    }
}
