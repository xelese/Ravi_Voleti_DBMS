package edu.northeastern.cs5200.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This class represents a table app manager.
 */
@Entity
@Table(name = "app_manager")
public class AppManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String password;

    @NotNull
    @Column(unique = true)
    private String username;

    @OneToMany(mappedBy = "appManager")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Feedback> feedback;

    @OneToMany(mappedBy = "appManager")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Reward> reward;

    public AppManager() {
    }

    // getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public List<Reward> getReward() {
        return reward;
    }

    public void setReward(List<Reward> reward) {
        this.reward = reward;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
