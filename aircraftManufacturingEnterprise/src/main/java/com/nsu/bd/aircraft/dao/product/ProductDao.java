package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    @Override
    List<Product> findAll();
}
