package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * This class is a mapping table between doctor and reward.
 */
@Entity
@Table(name = "doctor_reward")
@IdClass(DoctorRewardComposite.class)
public class DoctorReward {

    @Id
    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

    @Id
    @ManyToOne
    @JsonIgnore
    private Reward reward;

    // default constructor.
    public DoctorReward() {
    }

    public DoctorReward(Doctor doctor, Reward reward) {
        setDoctorReward(doctor);
        setRewardDoctor(reward);
    }

    // set reward for a doctor.
    public void setDoctorReward(Doctor doctor) {
        this.doctor = doctor;
        if (!doctor.getDoctorRewards().contains(this)) {
            doctor.getDoctorRewards().add(this);
        }
    }

    // set reward for a doctor.
    public void setRewardDoctor(Reward reward) {
        this.reward = reward;
        if (!reward.getDoctorReward().contains(this)) {
            doctor.getDoctorRewards().add(this);
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }
}
