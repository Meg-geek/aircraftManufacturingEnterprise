package com.nsu.bd.aircraft.api.dto.company;

import com.nsu.bd.aircraft.api.dto.staff.SiteManagerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteDto {
    private int id;
    private String workType;
    private GuildDto guild;
    private SiteManagerDto siteManager;
}
