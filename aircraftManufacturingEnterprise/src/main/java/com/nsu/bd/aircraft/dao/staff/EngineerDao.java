package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Engineer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerDao extends CrudRepository<Engineer, Integer> {
    @Override
    List<Engineer> findAll();

    @Query(value = "select staff.id, name, surname, site_id from engineers\n" +
            "    left join staff on staff.id = engineers.id\n" +
            "    left join site on engineers.site_id = site.id\n" +
            "    left join guild on guild.id = site.guild_id\n" +
            "where guild.company_id = :companyId",
            nativeQuery = true)
    List<Engineer> getByCompany(@Param("companyId") int companyId);

    @Query(value = "select staff.id, name, surname, site_id from engineers\n" +
            "    left join staff on staff.id = engineers.id\n" +
            "    left join site on engineers.site_id = site.id\n" +
            "where site.guild_id = :guildId",
            nativeQuery = true)
    List<Engineer> getByGuild(@Param("guildId") int guildId);
}
