package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.BrigadeDto;
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
    public GeneralResponse<?> addBrigade(@RequestBody BrigadeDto brigadeDto) {
        brigadeService.addBrigade(brigadeDto);
        return GeneralResponse.ok();
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<BrigadeDto>> getAllBrigades() {
        return new GeneralResponse<>(brigadeService.getAllBrigades());
    }

    @DeleteMapping("/delete-by-id")
    public void deleteById(@RequestParam("id") int id) {
        brigadeService.deleteById(id);
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
}
