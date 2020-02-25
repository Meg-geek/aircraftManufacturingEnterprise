package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.model.company.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void addCompany(Company company) {
        if (company == null) {
            return;
        }
        String sqlInsert = "INSERT INTO company (name) VALUES (:name) " +
                "RETURNING id;";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", company.getName());
        jdbcTemplate.update(sqlInsert, parameterSource, keyHolder);
        Number key = keyHolder.getKey();
        if (key != null) {
            company.setId(key.intValue());
        }
    }

}
