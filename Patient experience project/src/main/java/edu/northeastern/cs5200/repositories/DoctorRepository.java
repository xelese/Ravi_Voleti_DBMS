package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This interface represents a doctor repository that communicates with the doctor part of user table.
 */
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    /**
     * find the list of doctors.
     *
     * @param condition condition name.
     * @return the list of doctors.
     */
    @Query("SELECT doctor FROM Doctor doctor, Doctor_Conditions dc WHERE doctor.id = dc.doctor.id AND dc.conditionName =:condition")
    List<Doctor> findDoctorByConditions(@Param("condition") String condition);
}
