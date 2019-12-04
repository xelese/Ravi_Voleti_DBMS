package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.models.Role;

public class RoleDao implements RoleImpl {

  private static edu.northeastern.cs5200.daos.RoleDao instance = null;

  public RoleDao() {
  }

  // check if the instance of a role DAO exists.
  public static edu.northeastern.cs5200.daos.RoleDao getInstance() {

    if (instance == null) {
      instance = new edu.northeastern.cs5200.daos.RoleDao();
    }
    return instance;
  }

  @Override
  public void assignWebsiteRole(int developerId, Role role, int websiteId) {

    // SQL Query.
    String createWebsiteRole = "INSERT INTO cs5200.website_role(role,developer,website)" +
            " VALUES ((?), (?), (?));";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement websiteRoleStatement = connection.prepareStatement(createWebsiteRole);
      websiteRoleStatement.setString(1, role.toString());
      websiteRoleStatement.setInt(2, developerId);
      websiteRoleStatement.setInt(3, websiteId);
      websiteRoleStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }

  @Override
  public void assignPageRole(int developerId, Role role, int pageId) {

    // SQL Query.
    String createPageRole = "INSERT INTO cs5200.page_role(role,page,developer)" +
            " VALUES ((?), (?), (?));";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement roleStatement = connection.prepareStatement(createPageRole);
      roleStatement.setString(1, role.toString());
      roleStatement.setInt(2, pageId);
      roleStatement.setInt(3, developerId);
      roleStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }

  @Override
  public void deleteWebsiteRole(int developerId, int websiteId, int pageId) {

    // SQL Query.
    String deleteWebsiteRole = "delete from cs5200.website_role where website = (?) and" +
            " developer = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for developer.
      PreparedStatement statement = connection.prepareStatement(deleteWebsiteRole);
      statement.setInt(1, websiteId);
      statement.setInt(2, developerId);
      statement.executeUpdate();


    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }

  @Override
  public void deletePageRole(int developerId, int websiteId, int pageId) {

    // SQL Query.
    String deletePageRole = "delete from cs5200.page_role where page = (?) and developer = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for developer.
      PreparedStatement statement = connection.prepareStatement(deletePageRole);
      statement.setInt(1, pageId);
      statement.setInt(2,developerId);
      statement.executeUpdate();


    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }
}

