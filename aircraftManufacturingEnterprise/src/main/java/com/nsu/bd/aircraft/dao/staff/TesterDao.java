package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Tester;
import com.nsu.bd.aircraft.model.tests.Range;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TesterDao extends CrudRepository<Tester, Integer> {
    @Override
    List<Tester> findAll();

    @Query(value = "select tester.id, tester.range_id,\n" +
            "    name, surname from tester\n" +
            "    left join staff on tester.id = staff.id\n" +
            "    left join test on tester.id = test.tester_id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where pa.product_id = :productId and test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps\n" +
            "        ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Tester> getByProductAndRangeAndDateInterval(
            @Param("productId") int productId,
            @Param("rangeId") int rangeId,
            @Param("beginDate") Date beginDate,
            @Param("endDate") Date endDate
    );

    @Query(value = "select tester.id, tester.range_id,\n" +
            "       name, surname from tester\n" +
            "    left join staff on tester.id = staff.id\n" +
            "    left join test on tester.id = test.tester_id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps\n" +
            "        ( :beginDate , :endDate ) " +
            "    and pa.product_id in (select id from plane)",
            nativeQuery = true)
    List<Tester> getByRangeAndDateIntervalAndPlane(@Param("rangeId") int rangeId,
                                                   @Param("beginDate") Date beginDate,
                                                   @Param("endDate") Date endDate);

    @Query(value = "select tester.id, tester.range_id,\n" +
            "       name, surname from tester\n" +
            "    left join staff on tester.id = staff.id\n" +
            "    left join test on tester.id = test.tester_id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps\n" +
            "        ( :beginDate , :endDate ) " +
            "    and pa.product_id in (select id from rocket)",
            nativeQuery = true)
    List<Tester> getByRangeAndDateIntervalAndRocket(@Param("rangeId") int rangeId,
                                                    @Param("beginDate") Date beginDate,
                                                    @Param("endDate") Date endDate);

    @Query(value = "select tester.id, tester.range_id,\n" +
            "       name, surname from tester\n" +
            "    left join staff on tester.id = staff.id\n" +
            "    left join test on tester.id = test.tester_id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps\n" +
            "        ( :beginDate , :endDate ) " +
            "    and pa.product_id in (select id from helicopter)",
            nativeQuery = true)
    List<Tester> getByRangeAndDateIntervalAndHelicopter(@Param("rangeId") int rangeId,
                                                        @Param("beginDate") Date beginDate,
                                                        @Param("endDate") Date endDate);

    @Query(value = "select tester.id, tester.range_id,\n" +
            "       name, surname from tester\n" +
            "    left join staff on tester.id = staff.id\n" +
            "    left join test on tester.id = test.tester_id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps\n" +
            "        ( :beginDate , :endDate ) " +
            "    and pa.product_id in (select id from hang_glider)",
            nativeQuery = true)
    List<Tester> getByRangeAndDateIntervalAndHangGlider(@Param("rangeId") int rangeId,
                                                        @Param("beginDate") Date beginDate,
                                                        @Param("endDate") Date endDate);

    @Query(value = "select tester.id, tester.range_id,\n" +
            "       name, surname from tester\n" +
            "    left join staff on tester.id = staff.id\n" +
            "    left join test on tester.id = test.tester_id\n" +
            "    left join product_accounting pa on test.id = pa.test_id\n" +
            "where test.range_id = :rangeId " +
            "    and (begin_time, begin_time) overlaps\n" +
            "        ( :beginDate , :endDate ) ",
            nativeQuery = true)
    List<Tester> getByRangeAndDateInterval(@Param("rangeId") int rangeId,
                                           @Param("beginDate") Date beginDate,
                                           @Param("endDate") Date endDate);

    List<Tester> findByRange(Range range);
}
