package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * This class represents a treatment table.
 */
@Entity
@Table(name = "treatment")
@IdClass(TreatmentCompositeKey.class)
public class Treatment {

    @Id
    @ManyToOne
    @JsonIgnore
    private Patient patient;

    @Id
    @ManyToOne
    @JsonIgnore
    private Doctor doctor;


    @ManyToOne
    @JsonIgnore
    private Locality locality;

    @Id
    @NotNull
    private Date appointment;

    // default constructor.
    public Treatment() {
    }

    public Treatment(Doctor doctor, Patient patient, Date appointment, Locality locality) {
        setDoctorTreatment(doctor);
        setPatientTreatment(patient);
        setLocalityTreatment(locality);
        this.appointment = appointment;
    }

    // set locality for a treatment.
    public void setLocalityTreatment(Locality locality) {
        this.locality = locality;
        if (!locality.getTreatments().contains(this)) {
            locality.getTreatments().add(this);
        }
    }

    // set doctor for a treatment
    public void setDoctorTreatment(Doctor doctor) {
        this.doctor = doctor;
        if (!doctor.getTreatment().contains(this)) {
            doctor.getTreatment().add(this);
        }
    }

    // set patient for treatment.
    public void setPatientTreatment(Patient patient) {
        this.patient = patient;
        if (!patient.getTreatments().contains(this)) {
            patient.getTreatments().add(this);
        }
    }

    // getters and setters.
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

    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }
}
