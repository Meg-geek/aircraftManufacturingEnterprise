package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.HangGlider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface HangGliderDao extends CrudRepository<HangGlider, Integer> {
    @Override
    List<HangGlider> findAll();

    @Query(value = "select distinct hang_glider.type from hang_glider " +
            "left join products on hang_glider.id = products.id " +
            "left join guild on guild.id = products.guild_id " +
            "where company_id = :companyId", nativeQuery = true)
    List<String> findTypesByCompanyId(@Param("companyId") int companyId);

    @Query(value = "select distinct hang_glider.type from hang_glider " +
            "left join products on hang_glider.id = products.id " +
            "where guild_id = :guildId", nativeQuery = true)
    List<String> findTypesByGuildId(@Param("guildId") int guildId);

    @Query(value = "select hang_glider.id, hang_glider.type, " +
            "products.guild_id from hang_glider\n" +
            "        left join products on hang_glider.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = hang_glider.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and company_id = :companyId",
            nativeQuery = true)
    List<HangGlider> findByDateIntervalAndCompany(@Param("companyId") int companyId,
                                                  @Param("beginDate") Date beginDate,
                                                  @Param("endDate") Date endDate);

    @Query(value = "select hang_glider.id, hang_glider.type, " +
            "products.guild_id from hang_glider\n" +
            "        left join products on hang_glider.id = products.id\n" +
            "    left join product_accounting on product_accounting.product_id = hang_glider.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and products.guild_id = :guildId",
            nativeQuery = true)
    List<HangGlider> findByDateIntervalAndGuild(@Param("guildId") int guildId,
                                                @Param("beginDate") Date beginDate,
                                                @Param("endDate") Date endDate);

    @Query(value = "select hang_glider.id, hang_glider.type, " +
            "products.guild_id from hang_glider\n" +
            "        left join products on hang_glider.id = products.id\n" +
            "    left join product_accounting on product_accounting.product_id = hang_glider.id\n" +
            "where (begin_time, end_time) OVERLAPS ( :beginDate , :endDate )\n" +
            "  and site_id = :siteId",
            nativeQuery = true)
    List<HangGlider> findByDateIntervalAndSite(@Param("siteId") int siteId,
                                               @Param("beginDate") Date beginDate,
                                               @Param("endDate") Date endDate);

    @Query(value = "select hang_glider.id, hang_glider.type, " +
            "products.guild_id from hang_glider\n" +
            "left join products on hang_glider.id = products.id\n" +
            "left join product_accounting on product_accounting.product_id = hang_glider.id\n" +
            "where end_time is NULL and site_id = :siteId",
            nativeQuery = true)
    List<HangGlider> findNowBuildingBySite(@Param("siteId") int siteId);

    @Query(value = "select hang_glider.id, hang_glider.type, " +
            "products.guild_id from hang_glider\n" +
            "left join products on hang_glider.id = products.id\n" +
            "left join product_accounting on product_accounting.product_id = hang_glider.id\n" +
            "where end_time is null\n" +
            "and products.guild_id = :guildId",
            nativeQuery = true)
    List<HangGlider> findNowBuildingByGuild(@Param("guildId") int guildId);

    @Query(value = "select hang_glider.id, hang_glider.type, " +
            "products.guild_id from hang_glider\n" +
            "        left join products on hang_glider.id = products.id\n" +
            "        left join guild on guild.id = products.guild_id\n" +
            "    left join product_accounting on product_accounting.product_id = hang_glider.id\n" +
            "where end_time is null " +
            "  and company_id = :companyId",
            nativeQuery = true)
    List<HangGlider> findNowBuildingByCompany(@Param("companyId") int companyId);

    @Query(value = "select hang_glider.id, hang_glider.type, " +
            "p.guild_id from hang_glider\n" +
            "left join product_accounting on hang_glider.id = product_accounting.product_id\n" +
            "left join test on product_accounting.test_id = test.id\n" +
            "left join products p on hang_glider.id = p.id\n" +
            "where range_id = :rangeId and " +
            "(begin_time, end_time) OVERLAPS ( :beginDate , :endDate )",
            nativeQuery = true)
    List<HangGlider> findByDateIntervalAndRange(@Param("rangeId") int rangeId,
                                                @Param("beginDate") Date beginDate,
                                                @Param("endDate") Date endDate);
}
