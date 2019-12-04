package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.models.User;

public class UserDao implements UserImpl {

  private static UserDao instance = null;

  public UserDao() {
  }

  // check if the instance of a user DAO exists.
  public static UserDao getInstance() {

    if (instance == null) {
      instance = new UserDao();
    }
    return instance;
  }

  @Override
  public void createUser(User user) {

    // SQL Query.
    String createPerson = "insert into cs5200.person(id, first_name, last_name,"
            + " username, password, email, dob, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    String createUser = "insert into cs5200.user(id) values (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for person.
      PreparedStatement personStatement = connection.prepareStatement(createPerson);
      personStatement.setInt(1, user.getId());
      personStatement.setString(2, user.personId.getFirstName());
      personStatement.setString(3, user.personId.getLastName());
      personStatement.setString(4, user.personId.getUsername());
      personStatement.setString(5, user.personId.getPassword());
      personStatement.setString(6, user.personId.getEmail());
      personStatement.setDate(7, user.personId.getDob());
      personStatement.setString(8, user.personId.getAddress());
      personStatement.setString(9, user.personId.getPhone());
      personStatement.executeUpdate();


      // Configure Statement for user.
      PreparedStatement userStatement = connection.prepareStatement(createUser);
      userStatement.setInt(1, user.getId());
      userStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }
}
