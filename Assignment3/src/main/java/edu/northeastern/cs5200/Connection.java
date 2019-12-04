package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://cs5200.cnwbfkqaiv0g.us-east-1.rds."
          + "amazonaws.com/cs5200";
  private static final String USER = "admin";
  private static final String PASSWORD = "4657Ravi598!";
  private static java.sql.Connection dbConnection = null;

  public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(DRIVER);

    if (dbConnection == null) {
      dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
      return dbConnection;
    } else {
      return dbConnection;
    }
  }

  public static void closeConnection() {
    try {
      if (dbConnection != null) {
        dbConnection.close();
        dbConnection = null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
