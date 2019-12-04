package edu.northeastern.cs5200.models;

public class ImageWidget {

  //Data storage for table ImageWidget.
  private int id;
  private String src;

  // foreign key
  Widget widgetId;

  public ImageWidget(int id, String src)
  {
    this.id = id;
    this.src = src;
  }

  // Getters and Setters.

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }
}
