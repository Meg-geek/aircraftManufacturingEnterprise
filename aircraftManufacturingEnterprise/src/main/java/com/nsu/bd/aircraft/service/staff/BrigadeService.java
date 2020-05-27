package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.BrigadeDto;
import com.nsu.bd.aircraft.dao.staff.BrigadeDao;
import com.nsu.bd.aircraft.service.converters.staff.BrigadeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BrigadeService {
    private final BrigadeDao brigadeDao;
    private final BrigadeConverter brigadeConverter;

    @Transactional
    public void addBrigade(BrigadeDto brigadeDto) {
        brigadeDao.save(brigadeConverter.getBrigade(brigadeDto));
    }

    public List<BrigadeDto> getAllBrigades() {
        return brigadeConverter.getBrigadeDtos(brigadeDao.findAll());
    }

    @Transactional
    public void deleteById(int id) {
        brigadeDao.deleteById(id);
    }

    @Transactional
    public BrigadeDto updateBrigade(BrigadeDto brigadeDto) {
        return brigadeConverter
                .getBrigadeDto(brigadeDao
                        .save(brigadeConverter
                                .getBrigade(brigadeDto)));
    }
}
