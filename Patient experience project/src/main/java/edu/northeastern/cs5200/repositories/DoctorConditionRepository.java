package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Doctor_Conditions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This interface represents a repository that communicates with the doctor condition table.
 */
public interface DoctorConditionRepository extends CrudRepository<Doctor_Conditions, Integer> {

    /**
     * find the list of condition names.
     *
     * @param doctorId id to search by.
     * @return list of condition names.
     */
    @Query("select dc.conditionName from Doctor_Conditions dc where dc.doctor.id=:doctorId")
    List<String> findConditionByDoctorId(@Param("doctorId") Integer doctorId);
}
