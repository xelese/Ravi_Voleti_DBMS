package edu.northeastern.cs5200.models;


public class HtmlWidget {

  //Data storage for table HTMLWidget.
  private int id;
  private String html;

  // foreign key
  Widget widget;

  public HtmlWidget(int id, String html) {
    this.id = id;
    this.html = html;
  }

  public HtmlWidget() {
    super();
  }

  // Getters And Setters.

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }
}
