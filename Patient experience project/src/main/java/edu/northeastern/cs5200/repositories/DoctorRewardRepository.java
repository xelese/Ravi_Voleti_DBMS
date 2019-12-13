package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.DoctorReward;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents a repository that communicates with the doctor reward table.
 */
public interface DoctorRewardRepository extends CrudRepository<DoctorReward, Integer> {
}
