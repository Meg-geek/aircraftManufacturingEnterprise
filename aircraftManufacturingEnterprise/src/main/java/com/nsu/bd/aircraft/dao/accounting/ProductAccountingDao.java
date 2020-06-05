package com.nsu.bd.aircraft.dao.accounting;

import com.nsu.bd.aircraft.model.accounting.ProductAccounting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAccountingDao extends CrudRepository<ProductAccounting, Integer> {
    @Override
    List<ProductAccounting> findAll();

    @Query(value = "select distinct site.work_type from product_accounting\n" +
            "    left join site on site.id = product_accounting.site_id\n" +
            "where product_id = :productId",
            nativeQuery = true)
    List<String> getProductWorkTypesByProductId(@Param("productId") int productId);
}
