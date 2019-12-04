package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;

public class WebsiteDao implements WebsiteImpl {

  private static WebsiteDao instance = null;

  public WebsiteDao() {
  }

  // check if the instance of a website DAO exists.
  public static WebsiteDao getInstance() {

    if (instance == null) {
      instance = new WebsiteDao();
    }
    return instance;
  }

  @Override
  public void createWebsiteForDeveloper(int developerId, Website website) {

    // SQL Query.
    String createWebsite = "INSERT INTO cs5200.website(id,name,description,created," +
            "updated,visits, developer) VALUES ((?), (?), (?), (?), (?), (?), (?));";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement websiteStatement = connection.prepareStatement(createWebsite);
      websiteStatement.setInt(1, website.getId());
      websiteStatement.setString(2, website.getName());
      websiteStatement.setString(3, website.getDescription());
      websiteStatement.setDate(4, website.getCreated());
      websiteStatement.setDate(5, website.getUpdated());
      websiteStatement.setInt(6, website.getVisits());
      websiteStatement.setInt(7, developerId);
      websiteStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }

  @Override
  public Collection<Website> findAllWebsites() {

    // SQL Query.
    String findAllDevelopers = "select * from cs5200.website;";

    // initialize the array of websites.
    Collection<Website> websites = new ArrayList<>();

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Create object with data.
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findAllDevelopers);

      while (results.next()) {
        int websiteId = results.getInt("id");
        String websiteName = results.getString("name");
        String websiteDescription = results.getString("description");
        Date websiteCreated = results.getDate("created");
        Date websiteUpdated = results.getDate("updated");
        int websiteVisits = results.getInt("visits");
        int websiteDeveloper = results.getInt("developer");

        Website website = new Website(websiteId, websiteName, websiteDescription, websiteCreated,
                websiteUpdated, websiteVisits);
        websites.add(website);
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return new object.
    return websites;
  }

  @Override
  public Collection<Website> findWebsitesForDeveloper(int developerId) {// SQL Query.
    String findWebsiteForDeveloper = "select * from cs5200.website;";

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findWebsiteForDeveloper);

      // initialize the array of websites.
      Collection<Website> websites = new ArrayList<>();

      while (results.next()) {
        int websiteId = results.getInt("id");
        String websiteName = results.getString("name");
        String websiteDescription = results.getString("description");
        Date websiteCreated = results.getDate("created");
        Date websiteUpdated = results.getDate("updated");
        int websiteVisits = results.getInt("visits");
        int websiteDeveloper = results.getInt("developer");

        if (developerId == websiteDeveloper) {
          Website website = new Website(websiteId, websiteName, websiteDescription, websiteCreated,
                  websiteUpdated, websiteVisits);
          websites.add(website);
        }
      }

      return websites;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return null if nothing is found object.
    return null;
  }

  @Override
  public Website findWebsiteById(int websiteId) {

    String findWebsiteById = "select * from cs5200.website;";

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findWebsiteById);

      while (results.next()) {
        int id = results.getInt("id");
        String websiteName = results.getString("name");
        String websiteDescription = results.getString("description");
        Date websiteCreated = results.getDate("created");
        Date websiteUpdated = results.getDate("updated");
        int websiteVisits = results.getInt("visits");
        int websiteDeveloper = results.getInt("developer");

        if (websiteId == id) {
          return new Website(id, websiteName, websiteDescription, websiteCreated,
                  websiteUpdated, websiteVisits);
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
  public int updateWebsite(int websiteId, Website website) {

    String updateWebsite = "update cs5200.website w set w.name = (?)," +
            " w.description = (?), w.created = (?), w.updated = (?), w.visits = (?)" +
            "where w.id = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for person.
      PreparedStatement statement = connection.prepareStatement(updateWebsite);
      statement.setString(1, website.getName());
      statement.setString(2, website.getDescription());
      statement.setDate(3, website.getCreated());
      statement.setDate(4, website.getUpdated());
      statement.setInt(5, website.getVisits());
      statement.setInt(6, websiteId);
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
  public int deleteWebsite(int websiteId) {

    String deleteWebsite = "delete from cs5200.website where id = (?);";

    RoleImpl role = new RoleDao();
    role.deleteWebsiteRole(0,websiteId,0);

    PageImpl page = new PageDao();
    Collection<Page> pages = page.findPagesForWebsite(websiteId);

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement statement = connection.prepareStatement(deleteWebsite);
      statement.setInt(1, websiteId);
      statement.executeUpdate();

      return 1;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

    return -1;
  }
}
