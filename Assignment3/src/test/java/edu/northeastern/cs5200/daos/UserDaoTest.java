package edu.northeastern.cs5200.daos;

import org.junit.Test;

import edu.northeastern.cs5200.models.User;

public class UserDaoTest {

  @Test
  public void createUser() {
    UserImpl u = new UserDao();
    User user = new User(3,"loi", "koi");
    u.createUser(user);
  }

}