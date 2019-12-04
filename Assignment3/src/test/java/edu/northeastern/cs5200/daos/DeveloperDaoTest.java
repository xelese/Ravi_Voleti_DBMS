package edu.northeastern.cs5200.daos;

import org.junit.Before;
import org.junit.Test;

import edu.northeastern.cs5200.models.Developer;

public class DeveloperDaoTest {

  @Before
  public void setUp() throws Exception {
    DeveloperImpl d;
  }

  @Test
  public void testOne() {
    DeveloperImpl d = new DeveloperDao();
    Developer dev = new Developer(1,"fjcadwrhg","test","Dev");
    Developer dev2 = new Developer(2,"fjdvs","test2","Dev2",
            "uname", "pilav","xa@Ds.com", java.sql.Date.valueOf("2018-10-04")
    , "ALASS", "409851-0446");
    d.createDeveloper(dev);
    d.createDeveloper(dev2);

  }

  @Test
  public void testTwo() {
    DeveloperImpl d = new DeveloperDao();
    System.out.println(d.findAllDevelopers().toString());
  }

  @Test
  public void testThree() {
    DeveloperImpl d = new DeveloperDao();
    System.out.println(d.findDeveloperById(1).toString());
  }

  @Test
  public void testFour() {
    DeveloperImpl d = new DeveloperDao();
    System.out.println(d.findDeveloperByUsername("uname").toString());
  }

  @Test
  public void testFive() {
    DeveloperImpl d = new DeveloperDao();
    System.out.println(d.findDeveloperByCredentials("uname", "pilav").toString());
  }

  @Test
  public void testSix() {
    DeveloperImpl d = new DeveloperDao();
    Developer dev2 = new Developer(1,"sjss","test3","Dev3",
            "uname1", "pilav1","xa@Dadfadfs.com",
            java.sql.Date.valueOf("2019-11-14"));
    System.out.println(d.updateDeveloper(1, dev2));
  }

  @Test
  public void testSeven() {
    DeveloperImpl d = new DeveloperDao();
    System.out.println(d.deleteDeveloper(1));
  }

  @Test
  public void testEight() {
    DeveloperImpl d = new DeveloperDao();
    Developer dev2 = new Developer(2,null,"test",null,
            null, null,null, null);
    System.out.println(d.updateDeveloper(2, dev2));
  }

  @Test
  public void testNine() {
    DeveloperImpl d = new DeveloperDao();
    System.out.println(d.deleteDeveloper(2));
  }

  @Test
  public void test1() {

    DeveloperImpl developerDao = new DeveloperDao();

    Developer devUpdateAlicePrimary = new Developer(12, "4321rewq",
            "Alice", "Wonder", "alice", "alice",
            "alice@wonder.com", null, null, null);
    developerDao.updateDeveloper(12,devUpdateAlicePrimary);
  }
}