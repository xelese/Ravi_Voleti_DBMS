package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

  @Query("SELECT s FROM Student s")
  public List<Student> findAllStudents();

  /*@Query("SELECT s FROM Student WHERE section=:section")
  List<Student> findSectionForStudent(@Param("section") Section section);
*/

  @Query("SELECT student FROM Student student WHERE student.firstName=:firstName")
  public Student findStudentsByFirstName(@Param("firstName") String firstName);

}
