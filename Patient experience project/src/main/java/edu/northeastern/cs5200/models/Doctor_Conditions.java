package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * This class represents a table for conditions treatable by a doctor.
 */
@Entity
@Table(name = "doctor_condtion")
public class Doctor_Conditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

    @NotNull
    private String conditionName;

    // default constructor
    public Doctor_Conditions() {
    }

    // getters and setters.
    public Doctor_Conditions(String conditionName) {
        this.conditionName = conditionName;
    }

    // set condition for doctor.
    public void setDoctorCondition(Doctor doctor) {
        this.doctor = doctor;
        if (!doctor.getConditions().contains(this)) {
            doctor.getConditions().add(this);
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }
}
