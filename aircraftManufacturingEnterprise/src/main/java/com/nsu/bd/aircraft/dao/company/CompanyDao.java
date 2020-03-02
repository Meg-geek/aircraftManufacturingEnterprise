package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.model.company.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    Company findByName(String name);
}
