package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Discount;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents a repository that communicates with the reward table specifically the discount type in
 * the table.
 */
public interface DiscountRepository extends CrudRepository<Discount, Integer> {
}
