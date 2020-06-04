package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.company.Site;
import com.nsu.bd.aircraft.model.staff.Master;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterDao extends CrudRepository<Master, Integer> {
    @Override
    List<Master> findAll();

    @Query(value = "select id from master", nativeQuery = true)
    List<Integer> getIds();

    @Query(value = "select name, site_id, surname, master.id from master\n" +
            "    left join site on master.site_id= site.id\n" +
            "    left join staff on staff.id = master.id\n" +
            "    left join guild on guild.id = site.guild_id\n" +
            "where guild.company_id = :companyId",
            nativeQuery = true)
    List<Master> getByCompany(@Param("companyId") int companyId);

    @Query(value = "select name, site_id, surname, master.id from master\n" +
            "    left join site on master.site_id= site.id\n" +
            "    left join staff on staff.id = master.id\n" +
            "where site.guild_id = :guildId",
            nativeQuery = true)
    List<Master> getByGuild(@Param("guildId") int guildId);

    List<Master> getBySite(Site site);
}
