package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.model.company.Guild;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GuildDao extends CrudRepository<Guild, Integer> {
    List<Guild> findByCompanyId(int companyId);

    Guild findByGuildName(String guildName);

    @Override
    List<Guild> findAll();

    @Query(value = "select engineering_staff.id from engineering_staff " +
            "left join guild on guild.manager_id = engineering_staff.id " +
            "where guild.id = :guildId", nativeQuery = true)
    Optional<Integer> findGuildManagerIdByGuildId(@Param("guildId") int guildId);
}
