package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.AppManager;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents a repository that communicates with the app manager table.
 */
public interface AppManagerRepository extends CrudRepository<AppManager, Integer> {
}
