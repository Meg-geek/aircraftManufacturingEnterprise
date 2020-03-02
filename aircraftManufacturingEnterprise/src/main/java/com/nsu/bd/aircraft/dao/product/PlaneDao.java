package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Plane;
import org.springframework.data.repository.CrudRepository;

public interface PlaneDao extends CrudRepository<Plane, Integer> {
}
