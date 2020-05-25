package com.nsu.bd.aircraft.service.converters.company;

import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import com.nsu.bd.aircraft.model.company.Site;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteConverter {
    private final GuildConverter guildConverter;

    public Site getSite(SiteDto siteDto) {
        Site site = new Site();
        site.setId(siteDto.getId());
        site.setWorkType(siteDto.getWorkType());
        site.setGuild(guildConverter.getGuild(siteDto.getGuild()));
        return site;
    }

    public SiteDto getSiteDto(Site site) {
        return new SiteDto(site.getId(),
                site.getWorkType(),
                guildConverter.getGuildDto(site.getGuild()));
    }

    public List<SiteDto> getSiteDtos(List<Site> sites) {
        if (sites == null) {
            return emptyList();
        }
        return sites.stream()
                .map(this::getSiteDto)
                .collect(toList());
    }
}
