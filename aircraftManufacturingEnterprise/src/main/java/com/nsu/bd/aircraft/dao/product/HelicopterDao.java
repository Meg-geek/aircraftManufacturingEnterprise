package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Helicopter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface HelicopterDao extends CrudRepository<Helicopter, Integer> {
    @Override
    List<Helicopter> findAll();

    @Query(value = "select distinct helicopter.type from helicopter " +
            "left join products on helicopter.id = products.id " +
            "left join guild on guild.id = products.guild_id " +
            "where company_id = :companyId", nativeQuery = true)
    List<String> findTypesByCompanyId(@Param("companyId") int companyId);

    @Query(value = "select distinct helicopter.type from helicopter " +
            "left join products on helicopter.id = products.id " +
            "where guild_id = :guildId", nativeQuery = true)
    List<String> findTypesByGuildId(@Param("guildId") int guildId);

    @Query(value = "select helicopter.id, helicopter.weight, helicopter.type, " +
            "products.guild_id from helicopter\n" +
            "        left join products on helicopter.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = helicopter.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and company_id = :companyId",
            nativeQuery = true)
    List<Helicopter> findByDateIntervalAndCompany(@Param("companyId") int companyId,
                                                  @Param("beginDate") Date beginDate,
                                                  @Param("endDate") Date endDate);

    @Query(value = "select helicopter.id, helicopter.weight, helicopter.type, " +
            "products.guild_id from helicopter\n" +
            "        left join products on helicopter.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = helicopter.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and products.guild_id = :guildId",
            nativeQuery = true)
    List<Helicopter> findByDateIntervalAndGuild(@Param("guildId") int guildId,
                                                @Param("beginDate") Date beginDate,
                                                @Param("endDate") Date endDate);

    @Query(value = "select helicopter.id, helicopter.weight, helicopter.type, " +
            "products.guild_id from helicopter\n" +
            "        left join products on helicopter.id = products.id\n" +
            "    left join product_accounting on product_accounting.product_id = helicopter.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and site_id = :siteId",
            nativeQuery = true)
    List<Helicopter> findByDateIntervalAndSite(@Param("siteId") int siteId,
                                               @Param("beginDate") Date beginDate,
                                               @Param("endDate") Date endDate);

    @Query(value = "select helicopter.id, helicopter.weight, helicopter.type, " +
            "products.guild_id from helicopter\n" +
            "left join products on helicopter.id = products.id\n" +
            "left join product_accounting on product_accounting.product_id = helicopter.id\n" +
            "where end_time is NULL and site_id = :siteId",
            nativeQuery = true)
    List<Helicopter> findNowBuildingBySite(@Param("siteId") int siteId);

    @Query(value = "select helicopter.id, helicopter.weight, helicopter.type, " +
            "products.guild_id from helicopter\n" +
            "left join products on helicopter.id = products.id\n" +
            "left join product_accounting on product_accounting.product_id = helicopter.id\n" +
            "where end_time is null\n" +
            "and products.guild_id = :guildId",
            nativeQuery = true)
    List<Helicopter> findNowBuildingByGuild(@Param("guildId") int guildId);

    @Query(value = "select helicopter.id, helicopter.weight, helicopter.type, " +
            "products.guild_id from helicopter\n" +
            "        left join products on helicopter.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = helicopter.id\n" +
            "where end_time is null " +
            "  and company_id = :companyId",
            nativeQuery = true)
    List<Helicopter> findNowBuildingByCompany(@Param("companyId") int companyId);

    @Query(value = "select helicopter.id, helicopter.weight, helicopter.type, " +
            "p.guild_id from helicopter\n" +
            "left join product_accounting on helicopter.id = product_accounting.product_id\n" +
            "left join test on product_accounting.test_id = test.id\n" +
            "left join products p on helicopter.id = p.id\n" +
            "where range_id = :rangeId and " +
            "(begin_time, end_time) OVERLAPS ( :beginDate , :endDate )",
            nativeQuery = true)
    List<Helicopter> findByDateIntervalAndRange(@Param("rangeId") int rangeId,
                                                @Param("beginDate") Date beginDate,
                                                @Param("endDate") Date endDate);
}
