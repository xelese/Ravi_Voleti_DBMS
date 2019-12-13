package edu.northeastern.cs5200.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This class represents a table for locality.
 */
@Entity
@Table(name = "locality")
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String address;

    @OneToMany(mappedBy = "locality", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<DoctorLocation> doctor;

    @OneToMany(mappedBy = "locality", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Feedback> feedback;

    @OneToMany(mappedBy = "locality", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Reward> rewards;

    @OneToMany(mappedBy = "locality", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Treatment> treatments;

    // constructor
    public Locality() {
    }

    public Locality(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public List<DoctorLocation> getDoctorLocation() {
        return doctor;
    }

    public void setDoctorLocation(List<DoctorLocation> doctorLocation) {
        this.doctor = doctorLocation;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<DoctorLocation> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<DoctorLocation> doctor) {
        this.doctor = doctor;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
