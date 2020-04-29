package com.nsu.bd.aircraft.api.dto.company;

import com.nsu.bd.aircraft.model.company.Company;
import lombok.Data;

@Data
public class GuildDto {
    private final int id;
    private final String guildName;
    private final Company company;
    private final int managerId;
}
