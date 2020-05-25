package com.nsu.bd.aircraft.service.converters.staff;

import com.nsu.bd.aircraft.api.dto.staff.BrigadeDto;
import com.nsu.bd.aircraft.model.staff.Brigade;
import org.springframework.stereotype.Component;

@Component
public class BrigadeConverter {
    public Brigade getBrigade(BrigadeDto brigadeDto) {
        if (brigadeDto == null) {
            return null;
        }
        Brigade brigade = new Brigade();
        brigade.setId(brigadeDto.getId());
        return brigade;
    }

    public BrigadeDto getBrigadeDto(Brigade brigade) {
        if (brigade == null) {
            return null;
        }
        return new BrigadeDto(brigade.getId());
    }
}
