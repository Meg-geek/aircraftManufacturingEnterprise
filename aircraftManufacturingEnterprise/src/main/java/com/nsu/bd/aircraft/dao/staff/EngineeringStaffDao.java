package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.EngineeringStaff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineeringStaffDao extends CrudRepository<EngineeringStaff, Integer> {
    @Query("select staff from EngineeringStaff staff where staff.id not in (:managerIds)")
    List<EngineeringStaff> getFreeEngineeringStaff(
            @Param("managerIds") List<Integer> managerIds);

    @Query(value = "select site_manager_id from site", nativeQuery = true)
    List<Integer> getSiteManagerIds();

    @Query(value = "select manager_id from guild", nativeQuery = true)
    List<Integer> getGuildManagerIds();
}
