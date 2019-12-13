package edu.northeastern.cs5200.models;

import javax.persistence.Entity;

/**
 * This class represents a review. Extends feedback.
 */
@Entity
public class Review extends Feedback {

    private String review;

    public Review() {
        super();
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
