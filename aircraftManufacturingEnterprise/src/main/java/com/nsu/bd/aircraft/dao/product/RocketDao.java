package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Rocket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RocketDao extends CrudRepository<Rocket, Integer> {
    @Override
    List<Rocket> findAll();

    @Query(value = "select distinct rocket.type from rocket " +
            "left join products on rocket.id = products.id " +
            "left join guild on guild.id = products.guild_id " +
            "where company_id = :companyId", nativeQuery = true)
    List<String> findTypesByCompanyId(@Param("companyId") int companyId);

    @Query(value = "select distinct rocket.type from rocket " +
            "left join products on rocket.id = products.id " +
            "where guild_id = :guildId", nativeQuery = true)
    List<String> findTypesByGuildId(@Param("guildId") int guildId);

    @Query(value = "select rocket.id, rocket.charge_power, rocket.type, " +
            "products.guild_id from rocket\n" +
            "        left join products on rocket.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = rocket.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and company_id = :companyId",
            nativeQuery = true)
    List<Rocket> findByDateIntervalAndCompany(@Param("companyId") int companyId,
                                              @Param("beginDate") Date beginDate,
                                              @Param("endDate") Date endDate);

    @Query(value = "select rocket.id, rocket.charge_power, rocket.type, " +
            "products.guild_id from rocket\n" +
            "        left join products on rocket.id = products.id\n" +
            "    left join product_accounting on product_accounting.product_id = rocket.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and products.guild_id = :guildId",
            nativeQuery = true)
    List<Rocket> findByDateIntervalAndGuild(@Param("guildId") int guildId,
                                            @Param("beginDate") Date beginDate,
                                            @Param("endDate") Date endDate);

    @Query(value = "select rocket.id, rocket.charge_power, rocket.type, " +
            "products.guild_id from rocket\n" +
            "        left join products on rocket.id = products.id\n" +
            "    left join product_accounting on product_accounting.product_id = rocket.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and site_id = :siteId",
            nativeQuery = true)
    List<Rocket> findByDateIntervalAndSite(@Param("siteId") int siteId,
                                           @Param("beginDate") Date beginDate,
                                           @Param("endDate") Date endDate);

    @Query(value = "select rocket.id, rocket.charge_power, rocket.type, " +
            "products.guild_id from rocket\n" +
            "left join products on rocket.id = products.id\n" +
            "left join product_accounting on product_accounting.product_id = rocket.id\n" +
            "where end_time is NULL and site_id = :siteId",
            nativeQuery = true)
    List<Rocket> findNowBuildingBySite(@Param("siteId") int siteId);

    @Query(value = "select  rocket.id, rocket.charge_power, rocket.type, " +
            "products.guild_id from rocket\n" +
            "left join products on rocket.id = products.id\n" +
            "left join product_accounting on product_accounting.product_id = rocket.id\n" +
            "where end_time is null\n" +
            "and products.guild_id = :guildId",
            nativeQuery = true)
    List<Rocket> findNowBuildingByGuild(@Param("guildId") int guildId);

    @Query(value = "select rocket.id, rocket.charge_power, rocket.type, " +
            "products.guild_id from rocket\n" +
            "        left join products on rocket.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = rocket.id\n" +
            "where end_time is null " +
            "  and company_id = :companyId",
            nativeQuery = true)
    List<Rocket> findNowBuildingByCompany(@Param("companyId") int companyId);

    @Query(value = "select rocket.id, rocket.charge_power, rocket.type, " +
            "p.guild_id from rocket\n" +
            "left join product_accounting on rocket.id = product_accounting.product_id\n" +
            "left join test on product_accounting.test_id = test.id\n" +
            "left join products p on rocket.id = p.id\n" +
            "where range_id = :rangeId and " +
            "(begin_time, end_time) OVERLAPS ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Rocket> findByDateIntervalAndRange(@Param("rangeId") int rangeId,
                                            @Param("beginDate") Date beginDate,
                                            @Param("endDate") Date endDate);
}
