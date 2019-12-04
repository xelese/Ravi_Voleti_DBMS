package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.Developer;

public class DeveloperDao implements DeveloperImpl {

  private static DeveloperDao instance = null;

  public DeveloperDao() {
  }

  // check if the instance of a developer DAO exists.
  public static DeveloperDao getInstance() {

    if (instance == null) {
      instance = new DeveloperDao();
    }
    return instance;
  }

  @Override
  public void createDeveloper(Developer developer) {

    // SQL Query.
    String createPerson = "insert into cs5200.person(id, first_name, last_name,"
            + " username, password, email, dob, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    String createDeveloper = "insert into cs5200.developer(id, developer_key) values (?, ?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for person.
      PreparedStatement personStatement = connection.prepareStatement(createPerson);
      personStatement.setInt(1, developer.getId());
      personStatement.setString(2, developer.personId.getFirstName());
      personStatement.setString(3, developer.personId.getLastName());
      personStatement.setString(4, developer.personId.getUsername());
      personStatement.setString(5, developer.personId.getPassword());
      personStatement.setString(6, developer.personId.getEmail());
      personStatement.setDate(7, developer.personId.getDob());
      personStatement.setString(8, developer.personId.getAddress());
      personStatement.setString(9, developer.personId.getPhone());
      personStatement.executeUpdate();

      // Configure Statement for developer.
      PreparedStatement statement = connection.prepareStatement(createDeveloper);
      statement.setInt(1, developer.getId());
      statement.setString(2, developer.getDeveloperKey());
      statement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }

  @Override
  public Collection<Developer> findAllDevelopers() {

    // SQL Query.
    String findAllDevelopers = "select d.id, first_name, last_name, developer_key from"
            + " developer d join person p on d.id = p.id;";

    // initialize the array of developers.
    Collection<Developer> developers = new ArrayList<>();

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Create object with data.
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findAllDevelopers);

      while (results.next()) {
        int id = results.getInt("id");
        String developerKey = results.getString("developer_key");
        String firstName = results.getString("first_name");
        String lastName = results.getString("last_name");
        Developer developer = new Developer(id, developerKey, firstName, lastName);
        developers.add(developer);
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return new object.
    return developers;
  }

  @Override
  public Developer findDeveloperById(int developerId) {

    // SQL Query.
    String findDeveloperById = "select * from developer d join person p" +
            " on d.id = p.id;";

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findDeveloperById);

      while (results.next()) {
        int id = results.getInt("id");
        String developerKey = results.getString("developer_key");
        String firstName = results.getString("first_name");
        String lastName = results.getString("last_name");

        if (developerId == id) {
          return new Developer(id, developerKey, firstName, lastName);
        }
      }

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return null if nothing is found object.
    return null;
  }

  @Override
  public Developer findDeveloperByUsername(String username) {
    // SQL Query.
    String findDeveloperById = "select * from developer d join person p " +
            "on d.id = p.id;";

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findDeveloperById);

      while (results.next()) {
        int id = results.getInt("id");
        String developerKey = results.getString("developer_key");
        String firstName = results.getString("first_name");
        String lastName = results.getString("last_name");
        String queryUsername = results.getString("username");
        String password = results.getString("password");
        String email = results.getString("email");
        Date date = results.getDate("dob");

        if (username.equals(queryUsername)) {
          return new Developer(id, developerKey, firstName, lastName, queryUsername, password
                  , email, date);
        }
      }

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return null if nothing is found object.
    return null;
  }

  @Override
  public Developer findDeveloperByCredentials(String username, String password) {
    // SQL Query.
    String findDeveloperByCredentials = "select * from developer d join person p " +
            "on d.id = p.id;";

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findDeveloperByCredentials);

      while (results.next()) {
        int id = results.getInt("id");
        String developerKey = results.getString("developer_key");
        String firstName = results.getString("first_name");
        String lastName = results.getString("last_name");
        String queryUsername = results.getString("username");
        String queryPassword = results.getString("password");
        String email = results.getString("email");
        Date date = results.getDate("dob");

        if (username.equals(queryUsername) && password.equals(queryPassword)) {
          return new Developer(id, developerKey, firstName, lastName, queryUsername, queryPassword
                  , email, date);
        }
      }

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return null if nothing is found object.
    return null;
  }

  @Override
  public int updateDeveloper(int developerId, Developer developer) {

    // SQL Query.
    String updatePerson = "update person p set p.first_name = (?), p.last_name = (?),"
            + " p.username = (?), p.password = (?), p.email = (?), p.dob = (?), p.address = (?)," +
            " p.phone = (?) where p.id = (?);";

    String updateDeveloper = "update developer d set d.developer_key = (?)" +
            " where d.id = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for person.
      PreparedStatement personStatement = connection.prepareStatement(updatePerson);
      personStatement.setString(1, developer.personId.getFirstName());
      personStatement.setString(2, developer.personId.getLastName());
      personStatement.setString(3, developer.personId.getUsername());
      personStatement.setString(4, developer.personId.getPassword());
      personStatement.setString(5, developer.personId.getEmail());
      personStatement.setDate(6, developer.personId.getDob());
      personStatement.setString(7, developer.personId.getAddress());
      personStatement.setString(8, developer.personId.getPhone());
      personStatement.setInt(9, developerId);
      personStatement.executeUpdate();

      // Configure Statement for developer.
      PreparedStatement statement = connection.prepareStatement(updateDeveloper);
      statement.setString(1, developer.getDeveloperKey());
      statement.setInt(2, developerId);
      statement.executeUpdate();

      return 1;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

    return -1;
  }

  @Override
  public int deleteDeveloper(int developerId) {

    // SQL Query.
    String deletePerson = "delete from person where id = (?);";

    String deleteDeveloper = "delete from developer where id = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for developer.
      PreparedStatement statement = connection.prepareStatement(deleteDeveloper);
      statement.setInt(1, developerId);
      statement.executeUpdate();

      // Configure Statement for person.
      PreparedStatement personStatement = connection.prepareStatement(deletePerson);
      personStatement.setInt(1, developerId);
      personStatement.executeUpdate();

      return 1;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

    return -1;
  }
}
