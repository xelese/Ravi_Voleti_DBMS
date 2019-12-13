package edu.northeastern.cs5200.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a table for a patient. This class extends a user.
 */
@Entity
public class Patient extends User {

    @OneToMany(mappedBy = "patient")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Feedback> feedback;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Treatment> treatment;

    // constructor
    public Patient() {
        super();
        feedback = new ArrayList<>();
        treatment = new ArrayList<>();
    }

    // setters and getters.
    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public List<Treatment> getTreatments() {
        return treatment;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatment = treatments;
    }
}
