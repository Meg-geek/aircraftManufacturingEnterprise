package com.nsu.bd.aircraft.dao.tests;

import com.nsu.bd.aircraft.model.tests.Equipment;
import com.nsu.bd.aircraft.model.tests.Range;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface EquipmentDao extends CrudRepository<Equipment, Integer> {
    @Override
    List<Equipment> findAll();

    @Query(value = "select equipment.id, equipment.type, equipment.range_id from equipment\n" +
            "    left join equipment_test et on equipment.id = et.equipment_id\n" +
            "    left join test on et.test_id = test.id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where pa.product_id = :productId " +
            "    and test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps " +
            "       ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Equipment> getByProductAndRangeAndDateInterval(@Param("productId") int productId,
                                                        @Param("rangeId") int rangeId,
                                                        @Param("beginDate") Date beginDate,
                                                        @Param("endDate") Date endDate);

    @Query(value = "select equipment.id, equipment.type, equipment.range_id from equipment\n" +
            "    left join equipment_test et on equipment.id = et.equipment_id\n" +
            "    left join test on et.test_id = test.id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where pa.product_id in (select id from hang_glider) " +
            "    and test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps " +
            "       ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Equipment> getByRangeAndDateIntervalAndHangGlider(@Param("rangeId") int rangeId,
                                                           @Param("beginDate") Date beginDate,
                                                           @Param("endDate") Date endDate);

    @Query(value = "select equipment.id, equipment.type, equipment.range_id from equipment\n" +
            "    left join equipment_test et on equipment.id = et.equipment_id\n" +
            "    left join test on et.test_id = test.id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where pa.product_id in (select id from helicopter) " +
            "    and test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps " +
            "       ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Equipment> getByRangeAndDateIntervalAndHelicopter(@Param("rangeId") int rangeId,
                                                           @Param("beginDate") Date beginDate,
                                                           @Param("endDate") Date endDate);

    @Query(value = "select equipment.id, equipment.type, equipment.range_id from equipment\n" +
            "    left join equipment_test et on equipment.id = et.equipment_id\n" +
            "    left join test on et.test_id = test.id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where pa.product_id in (select id from plane) " +
            "    and test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps " +
            "       ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Equipment> getByRangeAndDateIntervalAndPlane(@Param("rangeId") int rangeId,
                                                      @Param("beginDate") Date beginDate,
                                                      @Param("endDate") Date endDate);

    @Query(value = "select equipment.id, equipment.type, equipment.range_id from equipment\n" +
            "    left join equipment_test et on equipment.id = et.equipment_id\n" +
            "    left join test on et.test_id = test.id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where pa.product_id in (select id from rocket) " +
            "    and test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps " +
            "       ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Equipment> getByRangeAndDateIntervalAndRocket(@Param("rangeId") int rangeId,
                                                       @Param("beginDate") Date beginDate,
                                                       @Param("endDate") Date endDate);


    @Query(value = "select equipment.id, equipment.type, equipment.range_id from equipment\n" +
            "    left join equipment_test et on equipment.id = et.equipment_id\n" +
            "    left join test on et.test_id = test.id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps " +
            "       ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Equipment> getByRangeAndDateInterval(@Param("rangeId") int rangeId,
                                              @Param("beginDate") Date beginDate,
                                              @Param("endDate") Date endDate);

    List<Equipment> findByRange(Range range);
}
