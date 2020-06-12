package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.BrigadeDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.BrigadeDao;
import com.nsu.bd.aircraft.model.staff.Brigade;
import com.nsu.bd.aircraft.service.converters.staff.BrigadeConverter;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BrigadeService {
    private final BrigadeDao brigadeDao;
    private final BrigadeConverter brigadeConverter;
    private final EmployeeConverter employeeConverter;

    @Transactional
    public BrigadeDto addBrigade(BrigadeDto brigadeDto) {
        return brigadeConverter
                .getBrigadeDto(saveBrigade(brigadeDto));
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

    public List<BrigadeDto> getBrigadesBySiteId(int siteId) {
        return brigadeConverter
                .getBrigadeDtos(brigadeDao.getBrigadesBySiteId(siteId));
    }

    public List<BrigadeDto> getBrigadesByGuildId(int guildId) {
        return brigadeConverter
                .getBrigadeDtos(brigadeDao.getBrigadesByGuildId(guildId));
    }

    public List<BrigadeDto> getBrigadesByProductId(int productId) {
        return brigadeConverter
                .getBrigadeDtos(brigadeDao.getBrigadesByProductId(productId));
    }

    @Transactional
    public void setSite(int brigadeId, int siteId) {
        brigadeDao.setSite(brigadeId, siteId);
    }

    @Transactional
    public void setForeman(int brigadeId, int staffId) {
        brigadeDao.setForeman(brigadeId, staffId);
    }


    private Brigade saveBrigade(BrigadeDto brigadeDto) {
        Brigade brigade = brigadeConverter.getBrigade(brigadeDto);
        Optional<Brigade> foundBrigade = brigadeDao.findById(brigade.getId());
        return foundBrigade.orElseGet(() -> brigadeDao.save(brigade));
    }

    public EmployeeDto getForeman(int brigadeId) {
        Optional<Brigade> foundBrigade = brigadeDao.findById(brigadeId);
        if (foundBrigade.isEmpty()) {
            return new EmployeeDto();
        }
        return employeeConverter.getEmployeeDto(foundBrigade.get().getForeman());
    }
}
