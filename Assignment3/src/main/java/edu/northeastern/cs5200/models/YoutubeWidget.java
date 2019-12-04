package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class YoutubeWidget {

  //Data storage for table YoutubeWidget.

  private int id;
  private String url;
  private boolean sharable;
  private boolean expandable;

  // foreign key
  Widget widgetId;

  // Getters and Setters.

  public YoutubeWidget(int id, String url, boolean sharable, boolean expandable) {
    this.id = id;
    this.url = url;
    this.sharable = sharable;
    this.expandable = expandable;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isSharable() {
    return sharable;
  }

  public void setSharable(boolean sharable) {
    this.sharable = sharable;
  }

  public boolean isExpandable() {
    return expandable;
  }

  public void setExpandable(boolean expandable) {
    this.expandable = expandable;
  }
}
