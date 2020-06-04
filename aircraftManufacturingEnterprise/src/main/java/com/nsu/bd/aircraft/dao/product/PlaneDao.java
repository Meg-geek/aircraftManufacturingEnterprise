package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Plane;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PlaneDao extends CrudRepository<Plane, Integer> {
    @Override
    List<Plane> findAll();

    @Query(value = "select distinct plane.type from plane " +
            "left join products on plane.id = products.id " +
            "left join guild on guild.id = products.guild_id " +
            "where company_id = :companyId", nativeQuery = true)
    List<String> findTypesByCompanyId(@Param("companyId") int companyId);

    @Query(value = "select distinct plane.type from plane " +
            "left join products on plane.id = products.id " +
            "where guild_id = :guildId", nativeQuery = true)
    List<String> findTypesByGuildId(@Param("guildId") int guildId);


    @Query(value = "select plane.id, plane.engine_amount, plane.type, " +
            "products.guild_id from plane\n" +
            "        left join products on plane.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = plane.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and company_id = :companyId",
            nativeQuery = true)
    List<Plane> findByDateIntervalAndCompany(@Param("companyId") int companyId,
                                             @Param("beginDate") Date beginDate,
                                             @Param("endDate") Date endDate);

    @Query(value = "select plane.id, plane.engine_amount, plane.type, " +
            "products.guild_id from plane\n" +
            "        left join products on plane.id = products.id\n" +
            "    left join product_accounting on product_accounting.product_id = plane.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and products.guild_id = :guildId",
            nativeQuery = true)
    List<Plane> findByDateIntervalAndGuild(@Param("guildId") int guildId,
                                           @Param("beginDate") Date beginDate,
                                           @Param("endDate") Date endDate);

    @Query(value = "select plane.id, plane.engine_amount, plane.type, " +
            "products.guild_id from plane\n" +
            "        left join products on plane.id = products.id\n" +
            "    left join product_accounting on product_accounting.product_id = plane.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and site_id = :siteId",
            nativeQuery = true)
    List<Plane> findByDateIntervalAndSite(@Param("siteId") int siteId,
                                          @Param("beginDate") Date beginDate,
                                          @Param("endDate") Date endDate);

    @Query(value = "select plane.id, plane.engine_amount, plane.type, " +
            "products.guild_id from plane\n" +
            "left join products on plane.id = products.id\n" +
            "left join product_accounting on product_accounting.product_id = plane.id\n" +
            "where end_time is NULL and site_id = :siteId",
            nativeQuery = true)
    List<Plane> findNowBuildingBySite(@Param("siteId") int siteId);

    @Query(value = "select  plane.id, plane.engine_amount, plane.type, " +
            "products.guild_id from plane\n" +
            "left join products on plane.id = products.id\n" +
            "left join product_accounting on product_accounting.product_id = plane.id\n" +
            "where end_time is null\n" +
            "and products.guild_id = :guildId",
            nativeQuery = true)
    List<Plane> findNowBuildingByGuild(@Param("guildId") int guildId);

    @Query(value = "select plane.id, plane.engine_amount, plane.type, " +
            "products.guild_id from plane\n" +
            "        left join products on plane.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = plane.id\n" +
            "where end_time is null " +
            "  and company_id = :companyId",
            nativeQuery = true)
    List<Plane> findNowBuildingByCompany(@Param("companyId") int companyId);
}
