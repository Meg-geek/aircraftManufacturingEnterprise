package com.nsu.bd.aircraft.service.accounting;


import com.nsu.bd.aircraft.api.dto.accounting.StageDto;
import com.nsu.bd.aircraft.dao.accounting.StageDao;
import com.nsu.bd.aircraft.service.converters.accounting.StageConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StageService {
    private final StageDao stageDao;
    private final StageConverter stageConverter;

    public List<StageDto> getAll() {
        return stageConverter.getStageDtos(stageDao.findAll());
    }

    @Transactional
    public void add(StageDto stageDto) {
        stageDao.save(stageConverter.getStage(stageDto));
    }

    public void deleteById(int id) {
        stageDao.deleteById(id);
    }

    @Transactional
    public StageDto update(StageDto stageDto) {
        return stageConverter
                .getStageDto(stageDao
                        .save(stageConverter
                                .getStage(stageDto)));
    }
}
