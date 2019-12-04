package edu.northeastern.cs5200.models;



public class HeadingWidget {

  //Data storage for table HeadingWidget.

  private int id;
  private int size;

  public HeadingWidget (int id, int size) {
    this.id = id;
    this.size = size;
  }

  // foreign key
  Widget widgetId;

  public HeadingWidget() {
    super();
  }

  // Getters and Setters.

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
