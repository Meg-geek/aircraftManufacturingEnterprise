package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Technician;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianDao extends CrudRepository<Technician, Integer> {
    @Override
    List<Technician> findAll();

    @Query(value = "select staff.id, name, surname, site_id from technicians\n" +
            "    left join staff on staff.id = technicians.id\n" +
            "    left join site on technicians.site_id = site.id\n" +
            "    left join guild on guild.id = site.guild_id\n" +
            "where guild.company_id = :companyId",
            nativeQuery = true)
    List<Technician> getByCompany(@Param("companyId") int companyId);

    @Query(value = "select staff.id, name, surname, site_id from technicians\n" +
            "    left join staff on staff.id = technicians.id\n" +
            "    left join site on technicians.site_id = site.id\n" +
            "where site.guild_id = :guildId",
            nativeQuery = true)
    List<Technician> getByGuild(@Param("guildId") int guildId);
}
