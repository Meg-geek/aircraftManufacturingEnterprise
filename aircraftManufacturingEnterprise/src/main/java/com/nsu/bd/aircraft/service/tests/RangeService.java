package com.nsu.bd.aircraft.service.tests;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.api.dto.tests.RangeDto;
import com.nsu.bd.aircraft.dao.tests.RangeDao;
import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.tests.Range;
import com.nsu.bd.aircraft.service.company.GuildService;
import com.nsu.bd.aircraft.service.converters.company.GuildConverter;
import com.nsu.bd.aircraft.service.converters.tests.RangeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RangeService {
    private final RangeDao rangeDao;
    private final RangeConverter rangeConverter;
    private final GuildService guildService;
    private final GuildConverter guildConverter;

    public Range addRange(Range range) {
        if (range == null) {
            return null;
        }
        Optional<Range> foundRange = rangeDao.findById(range.getId());
        return foundRange.orElseGet(() -> rangeDao.save(range));
    }

    @Transactional
    public RangeDto addRange(RangeDto rangeDto) {
        Range range = rangeConverter.getRange(rangeDto);
        List<Guild> guilds = range.getGuilds();
        if (guilds != null) {
            guilds = guilds.stream()
                    .map(guildService::addGuild)
                    .collect(Collectors.toList());
        }
        range.setGuilds(guilds);
        return rangeConverter
                .getRangeDto(addRange(range));
    }

    public List<RangeDto> getAllRanges() {
        return rangeConverter.getRangeDtos(rangeDao.findAll());
    }

    @Transactional
    public void deleteById(int rangeId) {
        rangeDao.deleteById(rangeId);
    }

    @Transactional
    public RangeDto updateRange(RangeDto rangeDto) {
        int id = rangeDao.updateRangeName(rangeDto.getId(), rangeDto.getName());
        changeGuilds(rangeDto);
        Optional<Range> range = rangeDao.findById(id);
        if (range.isPresent()) {
            return rangeConverter.getRangeDto(range.get());
        }
        return rangeDto;
    }

    public List<RangeDto> getByProductId(int productId) {
        return rangeConverter
                .getRangeDtos(rangeDao.getByProductId(productId));
    }

    @Transactional
    public void changeGuilds(RangeDto rangeDto) {
        Range range = addRange(rangeConverter.getRange(rangeDto));
        List<GuildDto> guildDtos = rangeDto.getGuilds();
        if (guildDtos == null || guildDtos.isEmpty()) {
            range.setGuilds(emptyList());
            rangeDao.save(range);
            return;
        }
        List<Guild> guilds = guildDtos.stream()
                .map(guildDto -> guildService.addGuild(guildConverter.getGuild(guildDto)))
                .collect(Collectors.toList());
        range.setGuilds(guilds);
        rangeDao.save(range);
    }

    public List<RangeDto> findByGuildId(int id) {
        return rangeConverter.getRangeDtos(rangeDao.findByGuild(id));
    }
}
