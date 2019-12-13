package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Reward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This interface represents a repository that communicates with reward table.
 */
public interface RewardRepository extends CrudRepository<Reward, Integer> {

    /**
     * find a reward with a given description.
     *
     * @param description description of the product.
     * @return reward.
     */
    @Query("SELECT r from Reward r where r.description =:desc")
    Reward findRewardByDescription(@Param("desc") String description);

    /**
     * find a list of rewards for a doctor and his registered locations.
     *
     * @param doctorId doctor id.
     * @return the list of reward for a doctor with his registered locations.
     */
    @Query("select r from Reward r, DoctorLocation dl, Locality l where r.locality.id = l.id and l.id = dl.locality.id and dl.doctor.id =:doctorId")
    List<Reward> findRewardByDoctorLocation(@Param("doctorId") Integer doctorId);

}
