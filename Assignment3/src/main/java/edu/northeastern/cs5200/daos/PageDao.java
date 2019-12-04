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

public class PageDao implements PageImpl {

  private static PageDao instance = null;

  public PageDao() {
  }

  // check if the instance of a website DAO exists.
  public static PageDao getInstance() {

    if (instance == null) {
      instance = new PageDao();
    }
    return instance;
  }

  @Override
  public void createPageForWebsite(int websiteId, Page page) {

    // SQL Query.
    String createPage = "INSERT INTO cs5200.page(id,title,description,created," +
            "updated,views, website) VALUES ((?), (?), (?), (?), (?), (?), (?));";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement pageStatement = connection.prepareStatement(createPage);
      pageStatement.setInt(1, page.getId());
      pageStatement.setString(2, page.getTitle());
      pageStatement.setString(3, page.getDescription());
      pageStatement.setDate(4, page.getCreated());
      pageStatement.setDate(5, page.getUpdated());
      pageStatement.setInt(6, page.getViews());
      pageStatement.setInt(7, websiteId);
      pageStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }

  @Override
  public Collection<Page> findAllPages() {

    // SQL Query.
    String findAllPage = "select * from cs5200.page;";

    // initialize the array of websites.
    Collection<Page> pages = new ArrayList<>();

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Create object with data.
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findAllPage);

      while (results.next()) {
        int pageId = results.getInt("id");
        String pageTitle = results.getString("title");
        String pageDescription = results.getString("description");
        Date pageCreated = results.getDate("created");
        Date pageUpdated = results.getDate("updated");
        int pageViews = results.getInt("views");

        Page page = new Page(pageId, pageTitle, pageDescription, pageCreated, pageUpdated,
                pageViews);
        pages.add(page);
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return new object.
    return pages;
  }

  @Override
  public Page findPageById(int pageId) {

    String findPageById = "select * from cs5200.page;";

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findPageById);

      while (results.next()) {
        int id = results.getInt("id");
        String pageTitle = results.getString("title");
        String pageDescription = results.getString("description");
        Date pageCreated = results.getDate("created");
        Date pageUpdated = results.getDate("updated");
        int pageViews = results.getInt("views");

        if (pageId == id) {
          return new Page(pageId, pageTitle, pageDescription, pageCreated, pageUpdated,
                  pageViews);
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
  public Collection<Page> findPagesForWebsite(int websiteId) {

    String findPageById = "select * from cs5200.page;";

    // initialize the array of websites.
    Collection<Page> pages = new ArrayList<>();

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findPageById);

      while (results.next()) {
        int pageId = results.getInt("id");
        String pageTitle = results.getString("title");
        String pageDescription = results.getString("description");
        Date pageCreated = results.getDate("created");
        Date pageUpdated = results.getDate("updated");
        int pageViews = results.getInt("views");
        int pageWebsite = results.getInt("website");

        if (websiteId == pageWebsite) {
          Page page = new Page(pageId, pageTitle, pageDescription, pageCreated, pageUpdated,
                  pageViews);
          pages.add(page);
        }
      }

      return pages;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return null if nothing is found object.
    return null;
  }

  @Override
  public int updatePage(int pageId, Page page) {

    String updatePage = "update cs5200.page p set p.title = (?)," +
            " p.description = (?), p.created = (?), p.updated = (?), p.views = (?)" +
            "where p.id = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for person.
      PreparedStatement pageStatement = connection.prepareStatement(updatePage);

      pageStatement.setString(1, page.getTitle());
      pageStatement.setString(2, page.getDescription());
      pageStatement.setDate(3, page.getCreated());
      pageStatement.setDate(4, page.getUpdated());
      pageStatement.setInt(5, page.getViews());
      pageStatement.setInt(6, pageId);
      pageStatement.executeUpdate();

      return 1;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

    return -1;
  }

  @Override
  public int deletePage(int pageId) {

    String deletePage = "delete from cs5200.page where id = (?);";

    RoleImpl role = new RoleDao();
    role.deletePageRole(0,0,pageId);

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement statement = connection.prepareStatement(deletePage);
      statement.setInt(1, pageId);
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
