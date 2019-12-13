package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Doctor;
import edu.northeastern.cs5200.models.Treatment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This interface represents a repository that communicates with a treatment table.
 */
public interface TreatmentRepository extends CrudRepository<Treatment, Integer> {

    /**
     * find a list of treatments for a doctor.
     *
     * @param doctor doctor id.
     * @return list of treatments.
     */
    @Query("SELECT treatment from Treatment treatment where treatment.doctor.id =:doctorId")
    List<Treatment> findTreatmentForDoctor(@Param("doctorId") Integer doctor);

    /**
     * find a list of treatments for a patient.
     *
     * @param patient patient id.
     * @return list of treatment.
     */
    @Query("SELECT treatment from Treatment treatment where treatment.patient.id =:patientId")
    List<Treatment> findTreatmentForPatient(@Param("patientId") Integer patient);

    /**
     * find the list of doctor id with a given patient.
     *
     * @param patientId patient id.
     * @return list of ids.
     */
    @Query("select t.doctor.id from Treatment t where t.patient.id=:patientId")
    List<Integer> findDoctorsForPatient(@Param("patientId") Integer patientId);

    /**
     * find locality name with a given patient id.
     *
     * @param patientId patient id.
     * @return list of locations for a patient.
     */
    @Query("select t.locality.name from Treatment t, Locality l where t.locality.id = l.id and t.patient.id =:patientId")
    List<String> findLocalityForPatient(@Param("patientId") Integer patientId);
}
