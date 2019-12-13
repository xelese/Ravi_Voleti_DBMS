package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * This class represents a table discount. This class extends table reward.
 */
@Entity
public class Discount extends Reward {

    @NotNull
    private String amount;

    public Discount() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
