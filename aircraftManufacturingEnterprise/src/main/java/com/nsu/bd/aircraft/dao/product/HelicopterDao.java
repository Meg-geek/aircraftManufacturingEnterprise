package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Helicopter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelicopterDao extends CrudRepository<Helicopter, Integer> {
    @Override
    List<Helicopter> findAll();
}
