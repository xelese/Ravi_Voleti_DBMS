package edu.northeastern.cs5200.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import edu.northeastern.cs5200.models.Person;

@Repository
public interface PersonRepository
        extends CrudRepository<Person, Integer> {
  @Query("SELECT p FROM Person p")
  public List<Person> findAllPersons();

}