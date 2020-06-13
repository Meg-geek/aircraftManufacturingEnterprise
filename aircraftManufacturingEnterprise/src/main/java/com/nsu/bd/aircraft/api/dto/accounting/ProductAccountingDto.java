package com.nsu.bd.aircraft.api.dto.accounting;

import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.api.dto.tests.TestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAccountingDto {
    private int id;
    private ProductDto product;
    private StageDto stage;
    private SiteDto site;
    private TestDto test;
    private long beginTime;
    private long endTime;
}
