package edu.northeastern.cs5200.daos;

import java.util.List;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

public interface UniversityInterface {

  void truncateDatabase();

  Faculty createFaculty(Faculty faculty);

  Student createStudent(Student student);

  Course createCourse(Course course);

  Section createSection(Section section);

  // TODO ADDED
  public void addTeacherToSection(Section section, Faculty faculty);

  Course addSectionToCourse(Section section, Course course);

  Course setAuthorForCourse(Faculty faculty, Course course);

  Boolean enrollStudentInSection(Student student, Section section);

  List<Course> findCoursesForAuthor(Faculty faculty);

  List<Section> findSectionForCourse(Course course);

  List<Section> findStudentsInSection(Student student);

  List<Student> findSectionForStudent(Section section);


}
