package com.nsu.bd.aircraft.api.dto.company;

import com.nsu.bd.aircraft.api.dto.staff.GuildManagerDto;
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
    private GuildManagerDto guildManager;

    public GuildDto(String guildName, CompanyDto company) {
        this.guildName = guildName;
        this.company = company;
    }

    public GuildDto(String guildName,
                    CompanyDto company,
                    GuildManagerDto guildManager) {
        this(guildName, company);
        this.guildManager = guildManager;
    }
}
