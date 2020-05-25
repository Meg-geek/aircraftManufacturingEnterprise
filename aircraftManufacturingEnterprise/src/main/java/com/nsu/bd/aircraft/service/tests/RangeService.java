package com.nsu.bd.aircraft.service.tests;

import com.nsu.bd.aircraft.dao.tests.RangeDao;
import com.nsu.bd.aircraft.model.tests.Range;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RangeService {
    private final RangeDao rangeDao;

    public Range addRange(Range range){
        if(range == null){
            return null;
        }
        return rangeDao.save(range);
    }
}
