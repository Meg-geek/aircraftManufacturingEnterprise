package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.company.Site;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SiteDao extends CrudRepository<Site, Integer> {
    @Override
    List<Site> findAll();

    @Query(value = "update site set site_manager_id = :managerId " +
            "where id = :siteId returning site.id", nativeQuery = true)
    Optional<Integer> updateSiteManager(@Param("siteId") int siteId,
                                        @Param("managerId") int newManagerId);

    @Query(value = "select engineering_staff.id from engineering_staff " +
            "left join site on site.site_manager_id = engineering_staff.id " +
            "where site.id = :siteId", nativeQuery = true)
    Optional<Integer> findSiteManagerIdBySiteId(@Param("siteId") int siteId);

    List<Site> findByGuild(Guild guild);

    @Query(value = "select site.id, work_type, guild_id, site_manager_id from site\n" +
            "    left join guild on site.guild_id = guild.id\n" +
            "where guild.company_id = :companyId", nativeQuery = true)
    List<Site> getByCompanyId(@Param("companyId") int companyId);
}
