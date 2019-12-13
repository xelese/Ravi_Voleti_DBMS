package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * This interface represents a repository that communicates with a user table.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
