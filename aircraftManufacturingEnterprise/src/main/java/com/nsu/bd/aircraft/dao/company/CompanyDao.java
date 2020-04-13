package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.model.company.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    Company findByName(String name);

    @Override
    List<Company> findAll();

    void deleteByName(String name);
}
