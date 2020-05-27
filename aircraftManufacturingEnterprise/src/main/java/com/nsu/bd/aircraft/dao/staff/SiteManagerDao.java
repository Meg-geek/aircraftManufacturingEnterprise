package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.SiteManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteManagerDao extends CrudRepository<SiteManager, Integer> {
    @Override
    List<SiteManager> findAll();
}
