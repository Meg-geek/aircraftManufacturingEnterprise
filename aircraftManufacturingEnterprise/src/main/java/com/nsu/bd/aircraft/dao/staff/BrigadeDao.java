package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Brigade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrigadeDao extends CrudRepository<Brigade, Integer> {
    @Override
    List<Brigade> findAll();

    @Query(value = "select * from brigade\n" +
            "where brigade.site_id = :siteId",
            nativeQuery = true)
    List<Brigade> getBrigadesBySiteId(@Param("siteId") int siteId);

    @Query(value = "select brigade.id, foreman_id, site_id from brigade\n" +
            "    left join site on brigade.site_id = site.id\n" +
            "where site.guild_id = :guildId", nativeQuery = true)
    List<Brigade> getBrigadesByGuildId(@Param("guildId") int guildId);

    @Query(value = "select distinct brigade.id, foreman_id, brigade.site_id from brigade\n" +
            "    left join product_accounting pa on brigade.site_id = pa.site_id\n" +
            "where product_id = :productId",
            nativeQuery = true)
    List<Brigade> getBrigadesByProductId(@Param("productId") int productId);

    @Query(value = "update brigade " +
            "set foreman_id = :staffId " +
            "where id = :brigadeId returning brigade.id",
            nativeQuery = true)
    Optional<Integer> setForeman(@Param("brigadeId") int brigadeId,
                                 @Param("staffId") int staffId);

    @Query(value = "update brigade " +
            "set site_id = :siteId " +
            "where id = :brigadeId returning brigade.id",
            nativeQuery = true)
    Optional<Integer> setSite(@Param("brigadeId") int brigadeId,
                              @Param("siteId") int siteId);
}
