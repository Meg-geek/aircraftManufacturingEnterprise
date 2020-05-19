package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneDao extends CrudRepository<Plane, Integer> {
    @Override
    List<Plane> findAll();
}
