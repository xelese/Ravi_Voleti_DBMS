package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Feedback;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This interface represents a repository that communicates with the feedback table.
 */
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    @Query("select f from Feedback f where f.appManager.id IS NULL")
    List<Feedback> findFeedbackByAppManager();
}
