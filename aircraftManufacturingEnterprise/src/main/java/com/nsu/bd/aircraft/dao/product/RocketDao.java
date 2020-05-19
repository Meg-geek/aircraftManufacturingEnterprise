package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Rocket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RocketDao extends CrudRepository<Rocket, Integer> {
    @Override
    List<Rocket> findAll();
}
