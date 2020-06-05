package com.nsu.bd.aircraft.service.tests;

import com.nsu.bd.aircraft.api.dto.tests.RangeDto;
import com.nsu.bd.aircraft.dao.tests.RangeDao;
import com.nsu.bd.aircraft.model.tests.Range;
import com.nsu.bd.aircraft.service.converters.tests.RangeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RangeService {
    private final RangeDao rangeDao;
    private final RangeConverter rangeConverter;

    public Range addRange(Range range) {
        if (range == null) {
            return null;
        }
        return rangeDao.save(range);
    }

    @Transactional
    public void addRange(RangeDto rangeDto) {
        rangeDao.save(rangeConverter.getRange(rangeDto));
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
        return rangeConverter
                .getRangeDto(rangeDao
                        .save(rangeConverter
                                .getRange(rangeDto)));
    }

    public List<RangeDto> getByProductId(int productId) {
        return rangeConverter
                .getRangeDtos(rangeDao.getByProductId(productId));
    }
}
