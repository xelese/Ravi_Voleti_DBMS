package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.CourseRepository;
import edu.northeastern.cs5200.repositories.EnrollmentRepository;
import edu.northeastern.cs5200.repositories.FacultyRepository;
import edu.northeastern.cs5200.repositories.PersonRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;

@Component
public class UniversityDao implements UniversityInterface {

  @Autowired
  FacultyRepository facultyRepository;

  @Override
  public Faculty createFaculty(Faculty faculty) {
    facultyRepository.save(faculty);
    return faculty;
  }

  @Autowired
  StudentRepository studentRepository;

  @Override
  public Student createStudent(Student student) {
    studentRepository.save(student);
    return student;
  }

  @Autowired
  CourseRepository courseRepository;

  @Override
  public Course createCourse(Course course) {
    courseRepository.save(course);
    return course;
  }

  @Autowired
  SectionRepository sectionRepository;

  @Override
  public Section createSection(Section section) {
    sectionRepository.save(section);
    return section;
  }

  @Autowired
  EnrollmentRepository enrollmentRepository;

  @Autowired
  PersonRepository personRepository;

  @Override
  public void truncateDatabase() {
    enrollmentRepository.deleteAll();
    courseRepository.deleteAll();
    studentRepository.deleteAll();
    facultyRepository.deleteAll();
    personRepository.deleteAll();
  }

  @Override
  public Course addSectionToCourse(Section section, Course course) {
    section.addSectionToCourse(course);
    sectionRepository.save(section);
    return course;
  }

  @Override
  public void addTeacherToSection(Section section, Faculty faculty) {
    section.setTeachesSection(faculty);
    sectionRepository.save(section);
    return;
  }

  @Override
  public Course setAuthorForCourse(Faculty faculty, Course course) {
    course.setAuthor(faculty);
    return courseRepository.save(course);
  }

  @Override
  public Boolean enrollStudentInSection(Student student, Section section) {

    if (section.getSeats() == 0) {
      return false;
    } else {
      Enrollment enrollment = new Enrollment(section, student);
      enrollmentRepository.save(enrollment);
      return true;
    }
  }

  @Override
  public List<Course> findCoursesForAuthor(Faculty faculty) {
    return faculty.getAuthoredCourses();
  }

  @Override
  public List<Section> findSectionForCourse(Course course) {
    return course.getCourseSections();
  }

  @Override
  public List<Section> findStudentsInSection(Student student) {
    return enrollmentRepository.findSectionForStudent(student);
  }

  @Override
  public List<Student> findSectionForStudent(Section section) {
    return enrollmentRepository.findStudentForSection(section);
  }

}
