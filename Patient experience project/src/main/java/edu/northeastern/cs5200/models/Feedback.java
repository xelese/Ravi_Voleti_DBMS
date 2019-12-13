package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * This class represents a table for feedback.
 */
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne
    @JsonIgnore
    private AppManager appManager;

    @ManyToOne
    @JsonIgnore
    private Locality locality;

    // default constructor.
    public Feedback() {
    }


    // set app manager feedback.
    public void setManagerFeedback(AppManager manager) {
        this.appManager = manager;
        if (!manager.getFeedback().contains(this)) {
            manager.getFeedback().add(this);
        }
    }

    // set doctor feedback.
    public void setDoctorFeedback(Doctor doctor) {
        this.doctor = doctor;
        if (!doctor.getFeedback().contains(this)) {
            doctor.getFeedback().add(this);
        }
    }

    // set patient feedback.
    public void setPatientFeedback(Patient patient) {
        this.patient = patient;
        if (!patient.getFeedback().contains(this)) {
            patient.getFeedback().add(this);
        }
    }

    // set locality feedback.
    public void setLocalityFeedback(Locality locality) {
        this.locality = locality;
        if (!locality.getFeedback().contains(this)) {
            locality.getFeedback().add(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public AppManager getAppManager() {
        return appManager;
    }

    public void setAppManager(AppManager appManager) {
        this.appManager = appManager;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }
}
