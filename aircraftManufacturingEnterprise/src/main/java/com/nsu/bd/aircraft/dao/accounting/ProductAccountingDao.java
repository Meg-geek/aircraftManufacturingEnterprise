package com.nsu.bd.aircraft.dao.accounting;

import com.nsu.bd.aircraft.model.accounting.ProductAccounting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAccountingDao extends CrudRepository<ProductAccounting, Integer> {
    @Override
    List<ProductAccounting> findAll();
}
