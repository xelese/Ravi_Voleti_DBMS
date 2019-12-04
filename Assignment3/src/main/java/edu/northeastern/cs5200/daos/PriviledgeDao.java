package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.models.Priviledge;

public class PriviledgeDao implements PriviledgeImpl {


  private static PriviledgeDao instance = null;

  public PriviledgeDao() {
  }

  // check if the instance of a website DAO exists.
  public static PriviledgeDao getInstance() {

    if (instance == null) {
      instance = new PriviledgeDao();
    }
    return instance;
  }


  @Override
  public void assignWebsitePrivilege(int developerId, int websiteId, String priviledge) {

    // SQL Query.
    String insertWebsitePriviledge = "INSERT INTO cs5200.website_priviledge(priviledge, developer, website)" +
            " VALUES ((?), (?), (?));";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement websitePriviledgeStatement = connection.prepareStatement(insertWebsitePriviledge);

      websitePriviledgeStatement.setString(1, priviledge);
      websitePriviledgeStatement.setInt(2, developerId);
      websitePriviledgeStatement.setInt(3, websiteId);
      websitePriviledgeStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }

  @Override
  public void assignPagePriviledge(int developerId, int pageId, String priviledge) {

    // SQL Query.
    String insertPagePriviledge = "INSERT INTO cs5200.page_priviledge(priviledge, page, developer)" +
            " VALUES ((?), (?), (?));";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement pagePrivilidgeStatement = connection.prepareStatement(insertPagePriviledge);

      pagePrivilidgeStatement.setString(1, priviledge);
      pagePrivilidgeStatement.setInt(2, pageId);
      pagePrivilidgeStatement.setInt(3, developerId);
      pagePrivilidgeStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();
  }

  @Override
  public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {

    // SQL Query.
    String insertWebsitePriviledge = "DELETE FROM cs5200.website_priviledge WHERE website = (?)" +
            " and developer = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement websitePriviledgeStatement = connection.prepareStatement(insertWebsitePriviledge);
      websitePriviledgeStatement.setInt(1, websiteId);
      websitePriviledgeStatement.setInt(2, developerId);
      websitePriviledgeStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void deletePagePriviledge(int developerId, int pageId, String priviledge) {

    // SQL Query.
    String insertWebsitePriviledge = "DELETE FROM cs5200.page_priviledge WHERE page = (?) and " +
            "developer = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement pagePriviledgeStatement = connection.prepareStatement(insertWebsitePriviledge);
      pagePriviledgeStatement.setInt(1, pageId);
      pagePriviledgeStatement.setInt(2, developerId);
      pagePriviledgeStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

  }
}
