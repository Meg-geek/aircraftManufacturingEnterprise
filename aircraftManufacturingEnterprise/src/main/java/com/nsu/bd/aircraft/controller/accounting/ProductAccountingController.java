package com.nsu.bd.aircraft.controller.accounting;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.accounting.ProductAccountingDto;
import com.nsu.bd.aircraft.service.accounting.ProductAccountingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/accounting/accounting")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductAccountingController {
    private final ProductAccountingService accountingService;

    @GetMapping("/get-all")
    public GeneralResponse<List<ProductAccountingDto>> getAll() {
        return new GeneralResponse<>(accountingService.getAll());
    }

    @PostMapping("/add")
    public GeneralResponse<?> add(@RequestBody ProductAccountingDto accountingDto) {
        log.info("ProductAccounting:: Get request to add accounting");
        accountingService.add(accountingDto);
        return GeneralResponse.ok();
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<?> deleteById(int id) {
        accountingService.deleteById(id);
        return GeneralResponse.ok();
    }

    @PutMapping("/update")
    public GeneralResponse<ProductAccountingDto> update(@RequestBody ProductAccountingDto accountingDto) {
        return new GeneralResponse<>(accountingService.update(accountingDto));
    }
}
