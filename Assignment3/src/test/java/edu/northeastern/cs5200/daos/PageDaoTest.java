package edu.northeastern.cs5200.daos;

import org.junit.Test;

import edu.northeastern.cs5200.models.Page;

import static org.junit.Assert.*;

public class PageDaoTest {

  @Test
  public void getInstance() {
  }

  @Test
  public void createPageForWebsite() {

    PageImpl page = new PageDao();
    Page p1 = new Page(1,"test","testdesc",java.sql.Date.valueOf("2016-04-12"),
            java.sql.Date.valueOf("2016-04-12"),13124);
    Page p2 = new Page(2,"test","testdesc",java.sql.Date.valueOf("2016-04-12"),
            java.sql.Date.valueOf("2016-04-12"),134673124);

    page.createPageForWebsite(1,p1);
    page.createPageForWebsite(2,p2);
  }

  @Test
  public void findAllPages() {
    PageImpl page = new PageDao();
    System.out.println(page.findAllPages().toString());
  }

  @Test
  public void findPageById() {
    PageImpl page = new PageDao();
    System.out.println(page.findPageById(1).toString());
  }

  @Test
  public void findPagesForWebsite() {
    PageImpl page = new PageDao();
    System.out.println(page.findPagesForWebsite(2).toString());
  }

  @Test
  public void updatePage() {
    PageImpl page = new PageDao();
    Page p1 = new Page(1,"test346","testdescqwrhg",
            java.sql.Date.valueOf("2016-04-12"), java.sql.Date.valueOf("2016-04-12"),
            13124);
    page.updatePage(1,p1);
  }

  @Test
  public void deletePage() {
    PageImpl page = new PageDao();
    page.deletePage(1);
  }
}