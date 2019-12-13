package edu.northeastern.cs5200.models;

import java.io.Serializable;
import java.sql.Date;

/**
 * This class represents a composite key between patient doctor and appointment.
 */
public class TreatmentCompositeKey implements Serializable {

    private Integer patient;
    private Integer doctor;
    private Date appointment;

}
