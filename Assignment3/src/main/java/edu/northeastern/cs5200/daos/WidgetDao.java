package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.DType;

import edu.northeastern.cs5200.models.Widget;

public class WidgetDao implements WidgetImpl {
  @Override
  public void createWidgetForPage(int pageId, Widget widget) {

    // SQL Query.
    String createWidget = "INSERT INTO cs5200.widget(id, name, width, height, css_class," +
            " css_style, text, `order`, youtube_url, youtube_shareble, youtube_expandable," +
            " image_source, heading_size, html, page, dtype) " +
            "VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?)," +
            " (?));";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for website.
      PreparedStatement widgetStatement = connection.prepareStatement(createWidget);
      widgetStatement.setInt(1, widget.getId());
      widgetStatement.setString(2, widget.getName());
      widgetStatement.setInt(3, widget.getWidth());
      widgetStatement.setInt(4, widget.getHeight());
      widgetStatement.setString(5, widget.getCssClass());
      widgetStatement.setString(6, widget.getCssStyle());
      widgetStatement.setString(7, widget.getText());
      widgetStatement.setInt(8, widget.getOrder());
      widgetStatement.setString(9, widget.getUrl());
      widgetStatement.setBoolean(10, widget.isSharable());
      widgetStatement.setBoolean(11, widget.isExpandable());
      widgetStatement.setString(12, widget.getSrc());
      widgetStatement.setInt(13, widget.getSize());
      widgetStatement.setString(14, widget.getHtml());
      widgetStatement.setInt(15, pageId);
      widgetStatement.setString(16, widget.getdType().toString());
      widgetStatement.executeUpdate();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

  }

  @Override
  public Collection<Widget> findAllWidgets() {
    // SQL Query.
    String findAllWidgets = "select * from cs5200.widget;";

    // initialize the array of websites.
    Collection<Widget> widgets = new ArrayList<>();

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Create object with data.
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findAllWidgets);

      while (results.next()) {

        int widgetId = results.getInt("id");
        String widgetName = results.getString("name");
        int widgetWidth = results.getInt("width");
        int widgetHeight = results.getInt("height");
        String widgetCssClass = results.getString("css_class");
        String widgetCssStyle = results.getString("css_style");
        String widgetText = results.getString("text");
        int widgetOrder = results.getInt("order");
        String widgetYoutubeUrl = results.getString("youtube_url");
        boolean widgetYoutubeSharable = results.getBoolean("youtube_shareble");
        boolean widgetYoutubeExpandable = results.getBoolean("youtube_expandable");
        String widgetImage = results.getString("image_source");
        int widgetSize = results.getInt("heading_size");
        String widgetHtml = results.getString("html");
        String widgetType = results.getString("dtype");

        Widget widget = new Widget
                (widgetId,
                        widgetName,
                        widgetWidth,
                        widgetHeight,
                        widgetCssClass,
                        widgetCssStyle,
                        widgetText,
                        widgetOrder,
                        widgetSize,
                        widgetHtml,
                        widgetImage,
                        widgetYoutubeUrl,
                        widgetYoutubeSharable,
                        widgetYoutubeExpandable,
                        DType.valueOf(widgetType));

        widgets.add(widget);
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    // return new object.
    return widgets;
  }

  @Override
  public Widget findWidgetById(int widgetId) {

    // SQL Query.
    String findWidgetById = "select * from cs5200.widget;";


    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Create object with data.
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findWidgetById);

      while (results.next()) {

        int id = results.getInt("id");
        String widgetName = results.getString("name");
        int widgetWidth = results.getInt("width");
        int widgetHeight = results.getInt("height");
        String widgetCssClass = results.getString("css_class");
        String widgetCssStyle = results.getString("css_style");
        String widgetText = results.getString("text");
        int widgetOrder = results.getInt("order");
        String widgetYoutubeUrl = results.getString("youtube_url");
        boolean widgetYoutubeSharable = results.getBoolean("youtube_shareble");
        boolean widgetYoutubeExpandable = results.getBoolean("youtube_expandable");
        String widgetImage = results.getString("image_source");
        int widgetSize = results.getInt("heading_size");
        String widgetHtml = results.getString("html");
        String widgetType = results.getString("dtype");

        if (id == widgetId) {

          Widget widget = new Widget
                  (id, widgetName, widgetWidth, widgetHeight, widgetCssClass,
                          widgetCssStyle, widgetText, widgetOrder, widgetSize, widgetHtml,
                          widgetImage, widgetYoutubeUrl, widgetYoutubeSharable,
                          widgetYoutubeExpandable, DType.valueOf(widgetType));

          return widget;

        }

      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    return null;
  }

  @Override
  public Collection<Widget> findWidgetsForPage(int pageId) {
    // SQL Query.
    String findWidgetById = "select * from cs5200.widget;";

    // initialize the array of websites.
    Collection<Widget> widgets = new ArrayList<>();

    try {
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Create object with data.
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findWidgetById);

      while (results.next()) {

        int id = results.getInt("id");
        String widgetName = results.getString("name");
        int widgetWidth = results.getInt("width");
        int widgetHeight = results.getInt("height");
        String widgetCssClass = results.getString("css_class");
        String widgetCssStyle = results.getString("css_style");
        String widgetText = results.getString("text");
        int widgetOrder = results.getInt("order");
        String widgetYoutubeUrl = results.getString("youtube_url");
        boolean widgetYoutubeSharable = results.getBoolean("youtube_shareble");
        boolean widgetYoutubeExpandable = results.getBoolean("youtube_expandable");
        String widgetImage = results.getString("image_source");
        int widgetSize = results.getInt("heading_size");
        String widgetHtml = results.getString("html");
        int widgetPage = results.getInt("page");
        String widgetType = results.getString("dtype");

        if (widgetPage == pageId) {

          Widget widget = new Widget
                  (id, widgetName, widgetWidth, widgetHeight, widgetCssClass,
                          widgetCssStyle, widgetText, widgetOrder, widgetSize, widgetHtml,
                          widgetImage, widgetYoutubeUrl, widgetYoutubeSharable,
                          widgetYoutubeExpandable, DType.valueOf(widgetType));

          widgets.add(widget);
        }
      }

      return widgets;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    edu.northeastern.cs5200.Connection.closeConnection();

    return null;
  }

  @Override
  public int updateWidget(int widgetId, Widget widget) {

    // SQL Query.
    String updateWidget = "update cs5200.widget w set w.name = (?),w.width = (?)," +
            "w.height = (?), w.css_class = (?), w.css_style = (?), w.text = (?), w.order = (?)" +
            ", w.youtube_url = (?), w.youtube_shareble = (?), w.youtube_expandable = (?)," +
            " w.image_source = (?), w.heading_size = (?),w.html = (?)," +
            " w.dtype = (?) where w.id = (?) ;";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for widget.
      PreparedStatement widgetStatement = connection.prepareStatement(updateWidget);
      widgetStatement.setString(1, widget.getName());
      widgetStatement.setInt(2, widget.getWidth());
      widgetStatement.setInt(3, widget.getHeight());
      widgetStatement.setString(4, widget.getCssClass());
      widgetStatement.setString(5, widget.getCssStyle());
      widgetStatement.setString(6, widget.getText());
      widgetStatement.setInt(7, widget.getOrder());
      widgetStatement.setString(8, widget.getUrl());
      widgetStatement.setBoolean(9, widget.isSharable());
      widgetStatement.setBoolean(10, widget.isExpandable());
      widgetStatement.setString(11, widget.getSrc());
      widgetStatement.setInt(12, widget.getSize());
      widgetStatement.setString(13, widget.getHtml());
      widgetStatement.setString(14, widget.getdType().toString());
      widgetStatement.setInt(15, widgetId);
      widgetStatement.executeUpdate();

      return 1;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

    return -1;
  }

  @Override
  public int deleteWidget(int widgetId) {

    // SQL QUERY
    String deleteWidget = "delete from cs5200.widget where id = (?);";

    // Create a connection
    try {

      // Instantiate connection.
      Connection connection = edu.northeastern.cs5200.Connection.getConnection();

      // Configure Statement for widget.
      PreparedStatement widgetStatement = connection.prepareStatement(deleteWidget);
      widgetStatement.setInt(1, widgetId);
      widgetStatement.executeUpdate();

      return 1;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // close connection
    edu.northeastern.cs5200.Connection.closeConnection();

    return -1;
  }
}
