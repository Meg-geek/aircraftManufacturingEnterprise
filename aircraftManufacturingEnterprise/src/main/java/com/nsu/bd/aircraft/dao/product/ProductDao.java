package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
