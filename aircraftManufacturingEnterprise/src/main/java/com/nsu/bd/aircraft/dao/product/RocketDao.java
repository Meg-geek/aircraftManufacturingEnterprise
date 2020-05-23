package com.nsu.bd.aircraft.dao.product;

import com.nsu.bd.aircraft.model.product.Rocket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}
