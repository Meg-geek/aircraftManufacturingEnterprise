package com.nsu.bd.aircraft.dao.tests;

import com.nsu.bd.aircraft.model.tests.Range;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RangeDao extends CrudRepository<Range, Integer> {
    @Override
    List<Range> findAll();

    @Query(value = "select range.id, range.name from range\n" +
            "    left join test t on range.id = t.range_id\n" +
            "where product_id = :productId",
            nativeQuery = true)
    List<Range> getByProductId(@Param("productId") int productId);
}
