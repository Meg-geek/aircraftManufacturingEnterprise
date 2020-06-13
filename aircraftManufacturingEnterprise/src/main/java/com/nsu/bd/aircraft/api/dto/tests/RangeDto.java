package com.nsu.bd.aircraft.api.dto.tests;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RangeDto {
    private int id;
    private String name;
    private List<GuildDto> guilds;
}
