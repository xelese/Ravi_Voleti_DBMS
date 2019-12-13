package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.DoctorLocation;
import edu.northeastern.cs5200.models.Locality;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This interface represents a repository that communicates with the doctor location table.
 */
public interface DoctorLocationRepository extends CrudRepository<DoctorLocation, Integer> {

    /**
     * find a list of localities for a doctor.
     *
     * @param doctorId doctor id.
     * @return list of locality names.
     */
    @Query("select dl.locality from DoctorLocation dl where dl.doctor.id=:doctorId")
    List<Locality> findLocationByDoctor(@Param("doctorId") Integer doctorId);

    @Query("select d from DoctorLocation d where d.locality.id=:localityId and d.doctor.id =:doctorId")
    DoctorLocation findDoctorLocation(@Param("doctorId") Integer doctorId, @Param("localityId") Integer localityId);

}
