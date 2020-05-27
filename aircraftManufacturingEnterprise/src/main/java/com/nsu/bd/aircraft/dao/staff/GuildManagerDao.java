package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.GuildManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuildManagerDao extends CrudRepository<GuildManager, Integer> {
    @Override
    List<GuildManager> findAll();
}
