package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;


/**
 * This class represents a Developer table.
 */


public class Developer {

  // Data storage for Developer Class.

  private int id;
  private String developerKey;

  //foreign key

  // to person.
  public Person personId;

  // to website.
  Collection<Website> websiteId;

  public Developer(int id, String developerKey, String firstName, String lastName) {


    this.id = id;
    this.developerKey = developerKey;

    personId = new Person(id, firstName, lastName, null, null, null,
            null, null, null);


  }

  public Developer(int id, String developerKey, String firstName, String lastName,
                   String username, String password, String email, Date dob) {


    this.id = id;
    this.developerKey = developerKey;

    personId = new Person(id, firstName, lastName, username, password, email, dob,
            null, null);


  }

  public Developer(int id, String developerKey, String firstName, String lastName, String username,
                   String password, String email, Date dob, String address, String phone) {


    this.id = id;
    this.developerKey = developerKey;

    personId = new Person(id, firstName, lastName, username, password, email, dob, address, phone);

  }

  // Getters and Setters.

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDeveloperKey() {
    return developerKey;
  }

  public void setDeveloperKey(String developerKey) {
    this.developerKey = developerKey;
  }

  // to String
  @Override
  public String toString() {
    return this.id + " " + this.developerKey + " " + this.personId.getFirstName() + " " +
            this.personId.getLastName() + " " + this.personId.getUsername() + " " +
            this.personId.getPassword() + " " + this.personId.getEmail()
            + " " + this.personId.getDob() + " " + this.personId.getAddress()
            + " " + this.personId.getPhone();
  }

}
