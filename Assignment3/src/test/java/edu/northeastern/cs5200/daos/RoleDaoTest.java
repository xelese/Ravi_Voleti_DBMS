package edu.northeastern.cs5200.daos;

import org.junit.Test;

import edu.northeastern.cs5200.models.Role;

import static org.junit.Assert.*;

public class RoleDaoTest {

  @Test
  public void assignWebsiteRole() {

    RoleImpl role = new RoleDao();
    role.assignWebsiteRole(2, Role.admin,1);

  }

  @Test
  public void assignPageRole() {

    RoleImpl role = new RoleDao();
    role.assignPageRole(2, Role.admin, 1);

  }

  @Test
  public void deleteWebsiteRole() {

    RoleImpl role = new RoleDao();
    role.deleteWebsiteRole(0,1,0);

  }

  @Test
  public void deletePageRole() {
    RoleImpl role = new RoleDao();
    role.deletePageRole(0,1,0);
  }
}