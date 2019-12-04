package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableDao implements CreateTableImpl {

  private static CreateTableDao instance = null;

  public CreateTableDao() {
  }

  // check if the instance of a developer DAO exists.
  public static CreateTableDao getInstance() {

    if (instance == null) {
      instance = new CreateTableDao();
    }
    return instance;
  }

  @Override
  public void createTable() {

    // SQL QUERY LIST

    String createPersonTable = "CREATE TABLE person" +
            "(" +
            "    id         int(11)     NOT NULL AUTO_INCREMENT," +
            "    first_name varchar(45) ," +
            "    last_name  varchar(45) ," +
            "    username   varchar(45) ," +
            "    password   varchar(45) ," +
            "    email      varchar(45) DEFAULT NULL," +
            "    dob        date," +
            "    address    varchar(45)," +
            "    phone      varchar(45)," +
            "    PRIMARY KEY (id)" +
            ");";

    String createUserTable = "CREATE TABLE user" +
            "(" +
            "    id             int(11) NOT NULL AUTO_INCREMENT," +
            "    user_agreement varchar(45) DEFAULT NULL," +
            "    PRIMARY KEY (id)," +
            "    CONSTRAINT user_person_generalization FOREIGN KEY (id) REFERENCES cs5200.person (id) ON UPDATE NO ACTION" +
            ");";

    String createDeveloperTable = "CREATE TABLE developer" +
            "(" +
            "    id            INT(11)     NOT NULL AUTO_INCREMENT," +
            "    developer_key VARCHAR(45) ," +
            "    PRIMARY KEY (id)," +
            "    CONSTRAINT developer_person_generalization FOREIGN KEY (id)" +
            "        REFERENCES cs5200.person (id)" +
            "        ON UPDATE NO ACTION" +
            ");";

    String createWebsiteTable = "CREATE TABLE website" +
            "(" +
            "    id          int(11)     NOT NULL AUTO_INCREMENT," +
            "    name        varchar(45) ," +
            "    description varchar(150) DEFAULT NULL," +
            "    created     date        ," +
            "    updated     date        ," +
            "    visits      int(11)     ," +
            "    developer   int(11)     ," +
            "    PRIMARY KEY (id)," +
            "    KEY developer_idx (developer)," +
            "    CONSTRAINT developer_self_generalization FOREIGN KEY (developer) REFERENCES cs5200.developer (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
            ");";

    String createPageTable = "CREATE TABLE page" +
            "(" +
            "    id          int(11)     NOT NULL AUTO_INCREMENT," +
            "    title       varchar(45) ," +
            "    description varchar(100) DEFAULT NULL," +
            "    created     date        ," +
            "    updated     date        ," +
            "    views       int(11)     ," +
            "    website     int(11)     ," +
            "    PRIMARY KEY (id)," +
            "    KEY website_idx (website)," +
            "    CONSTRAINT website_self_generalization FOREIGN KEY (website) REFERENCES cs5200.website (id) ON DELETE CASCADE ON UPDATE CASCADE" +
            ");";

    String createTypeOfWidget = "CREATE TABLE type_of_widget" +
            "(" +
            "    name varchar(45) ," +
            "    PRIMARY KEY (name)" +
            ");";

    String insertWidgetHeading = "INSERT INTO cs5200.type_of_widget" +
            "(name)" +
            "VALUES ('heading');;";

    String insertWidgetHtml = "INSERT INTO cs5200.type_of_widget" +
            "(name)" +
            "VALUES ('html');";

    String insertWidgetYoutube = "INSERT INTO cs5200.type_of_widget" +
            "(name)" +
            "VALUES ('youtube');";

    String insertWidgetImage = "INSERT INTO cs5200.type_of_widget" +
            "(name)" +
            "VALUES ('image');";

    String createTableWidget = "CREATE TABLE widget" +
            "(" +
            "    id                 int(11)     NOT NULL AUTO_INCREMENT," +
            "    name               varchar(45) ," +
            "    width              int(11)     DEFAULT NULL," +
            "    height             int(11)     DEFAULT NULL," +
            "    css_class          varchar(45) DEFAULT NULL," +
            "    css_style          varchar(45) DEFAULT NULL," +
            "    text               varchar(45) DEFAULT NULL," +
            "    `order`              int(11)     ," +
            "    youtube_url        varchar(45) DEFAULT NULL," +
            "    youtube_shareble   tinyint(4)  DEFAULT NULL," +
            "    youtube_expandable tinyint(4)  DEFAULT NULL," +
            "    image_source       varchar(45) DEFAULT NULL," +
            "    heading_size       int(5)      DEFAULT 2," +
            "    html               varchar(45) DEFAULT NULL," +
            "    page               int(11)     DEFAULT NULL," +
            "    dtype              varchar(45) ," +
            "    PRIMARY KEY (id)," +
            "    KEY page_idx (page)," +
            "    KEY dtype_idx (dtype)," +
            "    CONSTRAINT page_self_generalization FOREIGN KEY (page) REFERENCES cs5200.page (id) ON DELETE CASCADE ON UPDATE NO ACTION," +
            "    CONSTRAINT dtype_type_of_widget_generalization FOREIGN KEY (dtype) REFERENCES cs5200.type_of_widget (name) ON DELETE NO ACTION ON UPDATE NO ACTION" +
            ");";

    String createTablePriviledge = "CREATE TABLE priviledge" +
            "(" +
            "    name varchar(10) ," +
            "    PRIMARY KEY (name)" +
            ");";

    String insertPriviledgeCreate = "INSERT INTO cs5200.priviledge" +
            "(name)" +
            "VALUES ('create');";

    String insertPrivildegeRead = "INSERT INTO cs5200.priviledge" +
            "(name)" +
            "VALUES ('read');";

    String insertPriviledgeUpdate = "INSERT INTO cs5200.priviledge" +
            "(name)" +
            "VALUES ('update');";

    String insertPriviledgeDelete = "INSERT INTO cs5200.priviledge" +
            "(name)" +
            "VALUES ('delete');";

    String createTableRole = "CREATE TABLE role" +
            "(" +
            "    name varchar(10) ," +
            "    PRIMARY KEY (name)" +
            ");";

    String insertRoleOwner = "INSERT INTO cs5200.role" +
            "(name)" +
            "VALUES ('owner');";

    String insertRoleAdmin = "INSERT INTO cs5200.role" +
            "(name)" +
            "VALUES ('admin');";

    String insertRoleWriter = "INSERT INTO cs5200.role" +
            "(name)" +
            "VALUES ('writer');";

    String insertRoleEditor = "INSERT INTO cs5200.role" +
            "(name)" +
            "VALUES ('editor');";

    String insertRoleReviewer = "INSERT INTO cs5200.role" +
            "(name)" +
            "VALUES ('reviewer');";

    String createTableWebsitePriviledge = "CREATE TABLE website_priviledge" +
            "(" +
            "    id         int(11)     NOT NULL AUTO_INCREMENT," +
            "    priviledge varchar(45) ," +
            "    developer  int(11)     ," +
            "    website    int(11)     ," +
            "    PRIMARY KEY (id)," +
            "    KEY priviledge_idx (priviledge)," +
            "    KEY website_idx (website)," +
            "    KEY developer_idx (developer)," +
            "    CONSTRAINT website_priviledge_developer_self_generalization FOREIGN KEY (developer) REFERENCES cs5200.developer (id) ON DELETE CASCADE ON UPDATE CASCADE," +
            "    CONSTRAINT website_priviledge_self_generalization FOREIGN KEY (priviledge) REFERENCES cs5200.priviledge (name) ON DELETE NO ACTION ON UPDATE NO ACTION," +
            "    CONSTRAINT web FOREIGN KEY (website) REFERENCES cs5200.website (id) ON DELETE CASCADE ON UPDATE CASCADE" +
            ");";

    String createTableWebsiteRole = "CREATE TABLE website_role" +
            "(" +
            "    id        int(11)     NOT NULL AUTO_INCREMENT," +
            "    role      varchar(45) ," +
            "    developer int(11)     ," +
            "    website   int(11)     ," +
            "    PRIMARY KEY (id)," +
            "    KEY web_role_idx (role)," +
            "    KEY web_role_developer_idx (developer)," +
            "    KEY web_role_website_idx (website)," +
            "    CONSTRAINT website_role_self_generalization FOREIGN KEY (role) REFERENCES cs5200.role (name) ON DELETE NO ACTION ON UPDATE CASCADE," +
            "    CONSTRAINT web_role_developer_self_generalization FOREIGN KEY (developer) REFERENCES cs5200.developer (id) ON DELETE CASCADE ON UPDATE CASCADE," +
            "    CONSTRAINT web_role_website_self_generalization FOREIGN KEY (website) REFERENCES cs5200.website (id) ON DELETE CASCADE ON UPDATE CASCADE" +
            ");";

    String createTablePagePrivilidge = "CREATE TABLE page_priviledge" +
            "(" +
            "    id         int(11)     NOT NULL AUTO_INCREMENT," +
            "    priviledge varchar(45) ," +
            "    page       int(11)     ," +
            "    developer  int(11)     ," +
            "    PRIMARY KEY (id)," +
            "    KEY page_priviledge_idx (priviledge)," +
            "    KEY page_developer_idx (developer)," +
            "    KEY page_idx (page)," +
            "    CONSTRAINT page_priviledge_self_generalization FOREIGN KEY (priviledge) REFERENCES cs5200.priviledge (name) ON DELETE NO ACTION ON UPDATE NO ACTION," +
            "    CONSTRAINT page_priviledge_developer_self_generalization FOREIGN KEY (developer) REFERENCES cs5200.developer (id) ON DELETE CASCADE ON UPDATE CASCADE," +
            "    CONSTRAINT page_priviledge_page_self_generalization FOREIGN KEY (page) REFERENCES cs5200.page (id) ON DELETE CASCADE ON UPDATE CASCADE" +
            ");";

    String createTablePageRole = "CREATE TABLE page_role" +
            "(" +
            "    id        INT(11)     NOT NULL AUTO_INCREMENT," +
            "    role      VARCHAR(45) ," +
            "    page      INT(11)     ," +
            "    developer INT(11)     ," +
            "    PRIMARY KEY (id)," +
            "    KEY page_role_idx (role)," +
            "    KEY page_role_page_idx (page)," +
            "    KEY page_role_developer_idx (developer)," +
            "    CONSTRAINT page_role_self_generalization FOREIGN KEY (role)" +
            "        REFERENCES cs5200.role (name)" +
            "        ON DELETE NO ACTION ON UPDATE NO ACTION," +
            "    CONSTRAINT page_role_developer_generalization FOREIGN KEY (developer)" +
            "        REFERENCES cs5200.developer (id)" +
            "        ON DELETE CASCADE ON UPDATE CASCADE," +
            "    CONSTRAINT page_role_page_generalization FOREIGN KEY (page)" +
            "        REFERENCES cs5200.page (id)" +
            "        ON DELETE CASCADE ON UPDATE CASCADE" +
            ");";


    // connection
    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure PreparedStatement for person.
      PreparedStatement personStatement = connection.prepareStatement(createPersonTable);
      personStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement userStatement = connection.prepareStatement(createUserTable);
      userStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement developerStatement = connection.prepareStatement(createDeveloperTable);
      developerStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement websiteStatement = connection.prepareStatement(createWebsiteTable);
      websiteStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement pageStatement = connection.prepareStatement(createPageTable);
      pageStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement widgetTypeStatement = connection.prepareStatement(createTypeOfWidget);
      widgetTypeStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertHeadingStatement = connection.prepareStatement(insertWidgetHeading);
      insertHeadingStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertHtmlStatement = connection.prepareStatement(insertWidgetHtml);
      insertHtmlStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertYoutubeStatement = connection.prepareStatement(insertWidgetYoutube);
      insertYoutubeStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertImageStatement = connection.prepareStatement(insertWidgetImage);
      insertImageStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement widgetStatement = connection.prepareStatement(createTableWidget);
      widgetStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement priviledgeStatement = connection.prepareStatement(createTablePriviledge);
      priviledgeStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertCreateStatement = connection.prepareStatement(insertPriviledgeCreate);
      insertCreateStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertReadStatement = connection.prepareStatement(insertPrivildegeRead);
      insertReadStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertUpdateStatement = connection.prepareStatement(insertPriviledgeUpdate);
      insertUpdateStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertDeleteStatement = connection.prepareStatement(insertPriviledgeDelete);
      insertDeleteStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement roleStatement = connection.prepareStatement(createTableRole);
      roleStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertOwnerStatement = connection.prepareStatement(insertRoleOwner);
      insertOwnerStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertAdminStatement = connection.prepareStatement(insertRoleAdmin);
      insertAdminStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertWriterStatement = connection.prepareStatement(insertRoleWriter);
      insertWriterStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertEditorStatement = connection.prepareStatement(insertRoleEditor);
      insertEditorStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement insertReviewerStatement = connection.prepareStatement(insertRoleReviewer);
      insertReviewerStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement WebPriStatement = connection.prepareStatement(createTableWebsitePriviledge);
      WebPriStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement WebRoleStatement = connection.prepareStatement(createTableWebsiteRole);
      WebRoleStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement PagePriviledgeStatement = connection.prepareStatement(createTablePagePrivilidge);
      PagePriviledgeStatement.executeUpdate();

      // Configure PreparedStatement for person.
      PreparedStatement PageRoleStatement = connection.prepareStatement(createTablePageRole);
      PageRoleStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }
}