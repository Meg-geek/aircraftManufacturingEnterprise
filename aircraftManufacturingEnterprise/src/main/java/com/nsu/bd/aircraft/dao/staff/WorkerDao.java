package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Brigade;
import com.nsu.bd.aircraft.model.staff.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerDao extends CrudRepository<Worker, Integer> {
    List<Worker> getByBrigade(Brigade brigade);

    @Query(value = "update worker " +
            " set brigade_id = :brigadeId" +
            " where id = :workerId" +
            " returning id",
            nativeQuery = true)
    Optional<Integer> setWorkerBrigade(@Param("workerId") int workerId,
                                       @Param("brigadeId") int brigadeId);
}
