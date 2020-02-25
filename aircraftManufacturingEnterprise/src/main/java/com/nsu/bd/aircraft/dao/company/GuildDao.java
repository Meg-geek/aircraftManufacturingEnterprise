package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.dao.utils.EmployeeFieldsExtractor;
import com.nsu.bd.aircraft.model.company.Guild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void addGuild(Guild guild) {
        if (guild == null) {
            return;
        }
        String sqlInsert = "INSERT INTO guild (company_id, manager_id) " +
                "VALUES (:companyId, :managerId) " +
                "RETURNING id;";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("companyId", guild.getCompanyId())
                .addValue("managerId",
                        EmployeeFieldsExtractor.getId(guild.getGuildManager()));
        jdbcTemplate.update(sqlInsert, parameterSource, keyHolder);
        Number key = keyHolder.getKey();
        if (key != null) {
            guild.setId(key.intValue());
        }
    }
}
