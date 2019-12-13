package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * This class represents a mapping table between doctor and location. They together form a composite key.
 */
@Entity
@Table(name = "doctor_location")
@IdClass(DoctorLocationComposite.class)
public class DoctorLocation {

    @Id
    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

    @Id
    @ManyToOne
    @JsonIgnore
    private Locality locality;

    public DoctorLocation() {
    }

    public DoctorLocation(Doctor doctor, Locality locality) {
        setDoctorLocation(doctor);
        setLocalityDoctor(locality);
    }

    // doctor
    public void setDoctorLocation(Doctor doctor) {
        this.doctor = doctor;
        if (!doctor.getDoctorLocation().contains(this)) {
            doctor.getDoctorLocation().add(this);
        }
    }

    //locality
    public void setLocalityDoctor(Locality locality) {
        this.locality = locality;
        if (!locality.getDoctorLocation().contains(this)) {
            locality.getDoctorLocation().add(this);
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }
}
