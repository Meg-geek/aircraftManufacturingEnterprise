package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.model.company.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    Company findByName(String name);

    @Override
    List<Company> findAll();

    void deleteByName(String name);

    @Modifying
    @Query(value = "update company set name = :newName where id = :companyId",
            nativeQuery = true)
    void updateCompanyName(@Param("companyId") int companyId,
                           @Param("newName") String newName);
}
