package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import edu.northeastern.cs5200.models.Course;


public interface CourseRepository extends CrudRepository<Course, Integer> {

  @Query("SELECT c FROM Course c")
  public List<Course> findAllCourses();

  /*@Query("SELECT c FROM Course c WHERE c.sections=:sections")
  List<Course> findSectionForCourse(@Param("sections") Course course);
*/
  @Query("SELECT course FROM Course course WHERE course.label=:title")
  public Course findCourseByTitle(@Param("title") String title);

}
