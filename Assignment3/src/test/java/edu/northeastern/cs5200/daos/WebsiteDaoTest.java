package edu.northeastern.cs5200.daos;

import org.junit.Test;

import edu.northeastern.cs5200.models.Website;

public class WebsiteDaoTest {

  @Test
  public void getInstance() {
  }

  @Test
  public void createWebsiteForDeveloper() {

    WebsiteImpl w = new WebsiteDao();

    Website website1 = new Website(1, "test1", "loli",
            java.sql.Date.valueOf("2018-12-02"), java.sql.Date.valueOf("2018-12-02"),
            12345);

    Website website2 = new Website(2, "test2", "lo1",
            java.sql.Date.valueOf("2018-12-05"), java.sql.Date.valueOf("2018-12-05"),
            1213415);

    w.createWebsiteForDeveloper(1, website1);
    w.createWebsiteForDeveloper(2, website2);

  }

  @Test
  public void findAllWebsites() {
    WebsiteImpl w = new WebsiteDao();
    System.out.println(w.findAllWebsites());
  }

  @Test
  public void findWebsitesForDeveloper() {
    WebsiteImpl w = new WebsiteDao();
    System.out.println(w.findWebsitesForDeveloper(1).toString());
  }

  @Test
  public void findWebsiteById() {
    WebsiteImpl w = new WebsiteDao();
    System.out.println(w.findWebsiteById(2).toString());
  }

  @Test
  public void updateWebsite() {
    WebsiteImpl w = new WebsiteDao();
    Website website = new Website(2, "that", "noew loli",
            java.sql.Date.valueOf("2015-01-10"), java.sql.Date.valueOf("2015-06-17"), 8888);

    w.updateWebsite(2, website);
  }

  @Test
  public void deleteWebsite() {
    WebsiteImpl w = new WebsiteDao();
    w.deleteWebsite(1);
  }
}