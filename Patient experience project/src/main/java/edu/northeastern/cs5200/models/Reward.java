package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This class represents a reward table.
 */
@Entity
@Table(name = "reward")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(unique = true)
    private String description;

    @NotNull
    private Integer countOfReward;

    @OneToMany(mappedBy = "reward", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<DoctorReward> doctorReward;

    @ManyToOne
    @JsonIgnore
    private Locality locality;

    @ManyToOne
    @JsonIgnore
    private AppManager appManager;

    // default constructor.
    public Reward() {
    }

    // app manager
    public void setManagerReward(AppManager manager) {
        this.appManager = manager;
        if (!manager.getReward().contains(this)) {
            manager.getReward().add(this);
        }
    }

    // reward
    public void setDoctor(DoctorReward doctorsReward) {
        this.doctorReward.add(doctorsReward);
        if (doctorsReward.getReward() != this) {
            doctorsReward.setRewardDoctor(this);
        }
    }

    // getters and setters.
    public AppManager getAppManager() {
        return appManager;
    }

    public void setAppManager(AppManager appManager) {
        this.appManager = appManager;
    }

    public Integer getCountOfReward() {
        return countOfReward;
    }

    public void setCountOfReward(Integer countOfReward) {
        this.countOfReward = countOfReward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public List<DoctorReward> getDoctorReward() {
        return doctorReward;
    }

    public void setDoctorReward(List<DoctorReward> doctorReward) {
        this.doctorReward = doctorReward;
    }
}
