package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.HangGlider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HangGliderDao extends CrudRepository<HangGlider, Integer> {
    @Override
    List<HangGlider> findAll();
}
