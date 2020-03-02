package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Helicopter;
import org.springframework.data.repository.CrudRepository;

public interface HelicopterDao extends CrudRepository<Helicopter, Integer> {
}
