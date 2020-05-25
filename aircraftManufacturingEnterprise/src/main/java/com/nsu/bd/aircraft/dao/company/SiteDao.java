package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.model.company.Site;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SiteDao extends CrudRepository<Site, Integer> {
    @Override
    List<Site> findAll();
}
