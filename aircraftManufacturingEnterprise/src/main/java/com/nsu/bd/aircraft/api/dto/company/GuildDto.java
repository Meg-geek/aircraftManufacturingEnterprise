package com.nsu.bd.aircraft.api.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuildDto {
    private int id;
    private String guildName;
    private CompanyDto company;

    public GuildDto(String guildName, CompanyDto company) {
        this.guildName = guildName;
        this.company = company;
    }

}
