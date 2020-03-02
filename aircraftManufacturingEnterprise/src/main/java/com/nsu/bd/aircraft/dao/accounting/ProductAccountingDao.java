package com.nsu.bd.aircraft.dao.accounting;

import com.nsu.bd.aircraft.model.accounting.ProductAccounting;
import org.springframework.data.repository.CrudRepository;

public interface ProductAccountingDao extends CrudRepository<ProductAccounting, Integer> {
}
