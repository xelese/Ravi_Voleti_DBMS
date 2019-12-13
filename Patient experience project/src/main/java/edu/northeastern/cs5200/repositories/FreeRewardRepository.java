package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.FreeReward;
import org.springframework.data.repository.CrudRepository;

/**
 * This repository communicates with the reward table specifically the free reward type in the table.
 */
public interface FreeRewardRepository extends CrudRepository<FreeReward, Integer> {
}
