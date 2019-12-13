package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ReviewRepository extends CrudRepository<Review, Integer> {
    @Query("select r.review from Review r where r.id=:feedbackId")
    String findReviewForFeedback(@Param("feedbackId") Integer feedbackId);
}
