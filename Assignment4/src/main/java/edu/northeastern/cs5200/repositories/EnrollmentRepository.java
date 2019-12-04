package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {

  @Query("SELECT enrollment.sectionEnrolled FROM Enrollment enrollment WHERE enrollment.studentEnrolled=:student")
  public List<Section> findSectionForStudent(@Param("student") Student student);

  @Query("SELECT enrollment.studentEnrolled FROM Enrollment enrollment WHERE enrollment.sectionEnrolled=:section")
  public List<Student> findStudentForSection(@Param("section") Section section);
}