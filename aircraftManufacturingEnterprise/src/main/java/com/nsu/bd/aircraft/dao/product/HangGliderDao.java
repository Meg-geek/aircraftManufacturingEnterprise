package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.HangGlider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}
