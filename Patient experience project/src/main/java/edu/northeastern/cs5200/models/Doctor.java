package edu.northeastern.cs5200.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * This class represents a table doctor, extends table user.
 */
@Entity
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<DoctorLocation> locations;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Treatment> treatment;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Feedback> feedback;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Doctor_Conditions> conditions;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<DoctorReward> doctorRewards;

    // default constructor
    public Doctor() {
        super();
    }

    // add conditions treatable by a doctor.
    public void addTreatableCondition(Doctor_Conditions doctorConditions) {
        this.conditions.add(doctorConditions);
        if (doctorConditions.getDoctor() != this) {
            doctorConditions.setDoctorCondition(this);
        }
    }


    // set reward for the doctor reward table.
    public void setReward(DoctorReward doctorsReward) {
        this.doctorRewards.add(doctorsReward);
        if (doctorsReward.getDoctor() != this) {
            doctorsReward.setDoctorReward(this);
        }
    }

    // getters and setters.
    public List<Treatment> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<Treatment> treatment) {
        this.treatment = treatment;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public List<Doctor_Conditions> getConditions() {
        return conditions;
    }

    public void setConditions(List<Doctor_Conditions> conditions) {
        this.conditions = conditions;
    }

    public List<DoctorLocation> getDoctorLocation() {
        return locations;
    }

    public void setDoctorLocation(List<DoctorLocation> doctorLocation) {
        this.locations = doctorLocation;
    }

    public List<DoctorLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<DoctorLocation> locations) {
        this.locations = locations;
    }

    public List<DoctorReward> getDoctorRewards() {
        return doctorRewards;
    }

    public void setDoctorRewards(List<DoctorReward> doctorRewards) {
        this.doctorRewards = doctorRewards;
    }
}
