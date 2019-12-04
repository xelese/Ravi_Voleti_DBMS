package edu.northeastern.cs5200.models;

import java.util.Collection;
import java.sql.Date;

import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WebsiteImpl;


public class Page {

  // Data Storage for Page table.

  private int id;
  private String title;
  private String description;
  private Date created;
  private Date updated;
  private int views;

  // foreign key
  Website websiteId;

  Collection<Widget> widgetCollection;

  public Page(int id, String title, String description, Date created, Date updated, int views) {
    super();

    this.id = id;
    this.title = title;
    this.description = description;
    this.created = created;
    this.updated = updated;
    this.views = views;
  }

  // Getters and Setters.

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public int getViews() {
    return views;
  }

  public void setViews(int views) {
    this.views = views;
  }


  @Override
  public String toString() {
    return this.id + " " + this.title + " " + this.description + " " +
            this.created + " " + this.updated + " " + this.views + this.websiteId.getId();
  }
}
