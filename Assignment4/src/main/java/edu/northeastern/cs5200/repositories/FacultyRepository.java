package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

  @Query("SELECT faculty FROM Faculty faculty")
  public List<Faculty> findAllFaculty();

  @Query("SELECT faculty.authoredCourses FROM Faculty faculty WHERE faculty.id=:faculty")
  public List<Course> findCoursesForAuthor(@Param("faculty") Faculty faculty);

  @Query("SELECT faculty FROM Faculty faculty WHERE faculty.firstName=:firstName")
  public Faculty findFacultiesByFirstName(@Param("firstName") String firstName);

}
