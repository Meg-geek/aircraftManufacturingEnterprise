package com.nsu.bd.aircraft.api.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuildDto {
    private int id;
    private String guildName;
    private CompanyDto company;
    private int managerId;
}
