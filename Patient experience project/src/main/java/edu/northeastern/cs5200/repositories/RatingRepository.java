package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * This interface represents a repository that communicates with the rating part of feedback table.
 */
public interface RatingRepository extends CrudRepository<Rating, Integer> {

    @Query("select r.rating from Rating r where r.id=:feedbackId")
    Integer findRatingForFeedback(@Param("feedbackId") Integer feedbackId);

}
