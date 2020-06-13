package com.nsu.bd.aircraft.service.converters.tests;

import com.nsu.bd.aircraft.api.dto.tests.RangeDto;
import com.nsu.bd.aircraft.model.tests.Range;
import com.nsu.bd.aircraft.service.converters.company.GuildConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RangeConverter {
    private final GuildConverter guildConverter;

    public Range getRange(RangeDto rangeDto) {
        if (rangeDto == null) {
            return null;
        }
        Range range = new Range();
        range.setId(rangeDto.getId());
        range.setName(rangeDto.getName());
        range.setGuilds(guildConverter.getGuilds(rangeDto.getGuilds()));
        return range;
    }

    public RangeDto getRangeDto(Range range) {
        if (range == null) {
            return null;
        }
        return new RangeDto(range.getId(),
                range.getName(),
                guildConverter.getGuildDtosList(range.getGuilds()));
    }

    public List<RangeDto> getRangeDtos(List<Range> ranges) {
        if (ranges == null) {
            return emptyList();
        }
        return ranges.stream()
                .map(this::getRangeDto)
                .collect(toList());
    }
}
