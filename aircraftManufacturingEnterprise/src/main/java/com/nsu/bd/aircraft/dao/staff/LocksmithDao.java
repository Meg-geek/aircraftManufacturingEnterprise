package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Locksmith;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocksmithDao extends CrudRepository<Locksmith, Integer> {
    @Override
    List<Locksmith> findAll();

    @Query(value = "select staff.id, name, surname, brigade_id from worker\n" +
            "        left join brigade on brigade.id = worker.brigade_id\n" +
            "        left join site on brigade.site_id = site.id\n" +
            "        left join staff on staff.id = worker.id\n" +
            "        left join guild on guild.id = site.guild_id\n" +
            "where guild.company_id = :companyId and worker.id IN (select id from locksmiths)",
            nativeQuery = true)
    List<Locksmith> getByCompany(@Param("companyId") int companyId);

    @Query(value = "select staff.id, name, surname, brigade_id from worker\n" +
            "        left join brigade on brigade.id = worker.brigade_id\n" +
            "        left join site on brigade.site_id = site.id\n" +
            "        left join staff on staff.id = worker.id\n" +
            "where site.guild_id = :guildId and worker.id IN (select id from locksmiths);",
            nativeQuery = true)
    List<Locksmith> getByGuild(@Param("guildId") int guildId);

    @Query(value = "select staff.id, name, surname," +
            "brigade_id from staff " +
            "    left join worker on worker.id = staff.id " +
            "    where brigade_id is null" +
            " and staff.id in (select id from locksmiths)", nativeQuery = true)
    List<Locksmith> getFreeWorkers();
}
