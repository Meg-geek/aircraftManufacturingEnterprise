package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.dao.utils.EmployeeFieldsExtractor;
import com.nsu.bd.aircraft.model.company.Site;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void addSite(Site site) {
        if (site == null) {
            return;
        }
        String sqlInsert = "INSERT INTO site (guild_id, site_manager_id, work_type) " +
                "VALUES (:guildId, :siteManagerId, :workType) " +
                "RETURNING id;";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("guildId", site.getGuildId())
                .addValue("siteManagerId",
                        EmployeeFieldsExtractor.getId(site.getSiteManager()))
                .addValue("workType", site.getWorkType());
        jdbcTemplate.update(sqlInsert, parameterSource, keyHolder);
        Number key = keyHolder.getKey();
        if (key != null) {
            site.setId(key.intValue());
        }
    }
}
