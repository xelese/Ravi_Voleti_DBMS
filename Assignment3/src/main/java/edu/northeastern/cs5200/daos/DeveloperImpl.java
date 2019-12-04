package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.User;

/**
 * Interface represents operations that can be applied on the developer table.
 */

public interface DeveloperImpl {

  /**
   * inserts properties in developer instance parameter in tables Developer and Person.
   *
   * @param developer is an instance of class developer.
   */
  void createDeveloper(Developer developer);

  /**
   * returns all joined records from Developer and Person tables as a Collection of Developer
   * instances.
   *
   * @return all developers.
   */
  Collection<Developer> findAllDevelopers();

  /**
   * returns a joined record from Developer and Person tables whose id field is equal to the
   * developerId parameter
   *
   * @param developerId user given input for an id.
   * @return developer(s) of a given id.
   */
  Developer findDeveloperById(int developerId);

  /**
   * returns a joined record from Developer and Person tables whose username field matches the
   * parameter.
   *
   * @param username user given input for username
   * @return username of given input developer(s).
   */
  Developer findDeveloperByUsername(String username);

  /**
   * returns a joined record from Developer and Person tables whose username and password fields
   * match the parameters
   *
   * @param username user given input for username.
   * @param password user given input for password.
   * @return developer(s) with given input.
   */
  Developer findDeveloperByCredentials(String username, String password);

  /**
   * updates records in Developer and Person tables whose id field is equal to developerId
   * parameter. New record field values are set to the values in the developer instance parameter.
   *
   * @param developerId user given input for id.
   * @param developer   user given input for developer values.
   * @return updated developer credentials.
   */
  int updateDeveloper(int developerId, Developer developer);

  /**
   * deletes records from Developer and Person tables whose id field is equal to developerId
   * parameter. Do not make any modifications to the instance provided.
   *
   * @param developerId user given id.
   * @return deletes the developer record.
   */
  int deleteDeveloper(int developerId);

}
