package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * This class represents a table for free reward that extends a reward.
 */
@Entity
public class FreeReward extends Reward {

    @NotNull
    private String medicineName;

    // default constructor.
    public FreeReward() {
    }

    // getters and setters.
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
