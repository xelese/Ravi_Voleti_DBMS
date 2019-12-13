package edu.northeastern.cs5200.models;

import java.io.Serializable;

/**
 * This class forms the composite key between doctor and locality.
 */
public class DoctorLocationComposite implements Serializable {

    private Integer doctor;
    private Integer locality;
}
