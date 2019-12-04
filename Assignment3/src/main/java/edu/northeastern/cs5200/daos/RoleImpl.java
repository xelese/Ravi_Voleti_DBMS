package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Role;

public interface RoleImpl {

  void assignWebsiteRole(int developerId, Role role, int websiteId);

  void assignPageRole(int developerId, Role role, int pageId);

  void deleteWebsiteRole(int developerId, int websiteId, int roleId);

  void deletePageRole(int developerId, int pageId, int roleId);
}
