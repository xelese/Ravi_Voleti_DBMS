package edu.northeastern.cs5200.daos;

import org.junit.Test;

import edu.northeastern.cs5200.models.Priviledge;

import static org.junit.Assert.*;

public class PriviledgeDaoTest {

  @Test
  public void assignWebsitePrivilege() {

    PriviledgeImpl priviledge = new PriviledgeDao();
    priviledge.assignWebsitePrivilege(1,1, Priviledge.create.toString());
  }

  @Test
  public void assignPagePriviledge() {

    PriviledgeImpl priviledge = new PriviledgeDao();
    priviledge.assignPagePriviledge(1,1, Priviledge.create.toString());
  }

  @Test
  public void deleteWebsitePriviledge() {

    PriviledgeImpl priviledge = new PriviledgeDao();
    priviledge.deleteWebsitePriviledge(0, 1, Priviledge.create.toString());

  }

  @Test
  public void deletePagePriviledge() {
    PriviledgeImpl priviledge = new PriviledgeDao();
    priviledge.deletePagePriviledge(0,1,Priviledge.create.toString());
  }
}