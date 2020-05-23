package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Helicopter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}
