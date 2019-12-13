package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * This class represents a rating. Extends feedback. Restricts value between 1 and 5.
 */
@Entity
public class Rating extends Feedback {

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private Double rating;

    public Rating() {
        super();
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
