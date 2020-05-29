package com.nsu.bd.aircraft.service.converters.accounting;

import com.nsu.bd.aircraft.api.dto.accounting.StageDto;
import com.nsu.bd.aircraft.model.accounting.Stage;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
public class StageConverter {
    public Stage getStage(StageDto stageDto) {
        if (stageDto == null) {
            return null;
        }
        return new Stage(stageDto.getId(), stageDto.getStageName());
    }

    public StageDto getStageDto(Stage stage) {
        if (stage == null) {
            return null;
        }
        return new StageDto(stage.getId(), stage.getStageName());
    }

    public List<StageDto> getStageDtos(List<Stage> stages) {
        if (stages == null) {
            return emptyList();
        }
        return stages.stream()
                .map(this::getStageDto)
                .collect(toList());
    }
}
