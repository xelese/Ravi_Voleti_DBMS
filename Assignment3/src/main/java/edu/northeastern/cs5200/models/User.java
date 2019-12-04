package edu.northeastern.cs5200.models;


/**
 * This class represents a User table.
 */

public class User {

  // Data storage for table User.
  private int id;
  private boolean userAgreement;

  // foreign key entities.
  public Person personId;

  public User(int id, String firstName, String lastName) {
    super();

    this.id = id;

    personId = new Person(id, firstName, lastName, null, null, null,
            null, null, null);
  }

  public User(int id, String firstName, String lastName, String username, String password,
              String email) {
    super();

    this.id = id;

    personId = new Person(id, firstName, lastName, username, password, email,
            null, null, null);
  }

  // Getter and Setter.


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isUserAgreement() {
    return userAgreement;
  }

  public void setUserAgreement(boolean userAgreement) {
    this.userAgreement = userAgreement;
  }
}
