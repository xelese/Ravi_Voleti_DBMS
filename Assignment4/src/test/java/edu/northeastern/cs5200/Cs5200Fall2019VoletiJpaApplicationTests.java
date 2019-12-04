package edu.northeastern.cs5200;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import edu.northeastern.cs5200.daos.UniversityDao;
import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.CourseRepository;
import edu.northeastern.cs5200.repositories.EnrollmentRepository;
import edu.northeastern.cs5200.repositories.FacultyRepository;
import edu.northeastern.cs5200.repositories.PersonRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cs5200Fall2019VoletiJpaApplicationTests {

  @Test
  public void contextLoads() {
  }

  @Autowired
  UniversityDao university;

  @Autowired
  FacultyRepository facultyRepository;

  @Autowired
  CourseRepository courseRepository;

  @Autowired
  SectionRepository sectionRepository;

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  PersonRepository personRepository;

  @Autowired
  EnrollmentRepository enrollmentRepository;


  // Inserts

  @Test
  public void testOneEmptyTheDatabase() {
    university.truncateDatabase();
  }

  @Test
  public void testTwoCreateFaculties() {
    Faculty facultyAlan = new Faculty("Alan", "Turin", "alan",
            "password", "123A", true);

    Faculty facultyAda = new Faculty("Ada", "Lovelace", "ada",
            "password", "123B", true);

    university.createFaculty(facultyAlan);
    university.createFaculty(facultyAda);

  }

  @Test
  public void testThreeCreateStudents() {
    Student studentAlice = new Student("Alice", "Wonderland", "alice",
            "password", 2020, 12000);

    Student studentBob = new Student("Bob", "Hope", "bob",
            "password", 2021, 23000);

    Student studentCharlie = new Student("Charlie", "Brown", "charlie",
            "password", 2019, 21000);

    Student studentDan = new Student("Dan", "Craig", "dan",
            "password", 2019, 0);

    Student studentEdward = new Student("Edward", "Scissorhands", "edward",
            "password", 2022, 11000);

    Student studentFrank = new Student("Frank", "Herbert", "frank",
            "password", 2018, 0);

    Student studentGregory = new Student("Gregory", "Peck", "gregory",
            "password", 2023, 10000);

    university.createStudent(studentAlice);
    university.createStudent(studentBob);
    university.createStudent(studentCharlie);
    university.createStudent(studentDan);
    university.createStudent(studentEdward);
    university.createStudent(studentFrank);
    university.createStudent(studentGregory);

  }

  @Test
  public void testFourCreateCourses() {

    // Courses
    Course courseCS1234 = new Course("CS1234");
    Course courseCS2345 = new Course("CS2345");
    Course courseCS3456 = new Course("CS3456");
    Course courseCS4567 = new Course("CS4567");

    // add authors to table
    university.createCourse(courseCS1234);
    university.createCourse(courseCS2345);
    university.createCourse(courseCS3456);
    university.createCourse(courseCS4567);

    //Faculties
    Faculty facultyAlan = facultyRepository.findFacultiesByFirstName("Alan");
    Faculty facultyAda = facultyRepository.findFacultiesByFirstName("Ada");

    // Courses
    Course course1234 = courseRepository.findCourseByTitle("CS1234");
    Course course2345 = courseRepository.findCourseByTitle("CS2345");
    Course course3456 = courseRepository.findCourseByTitle("CS3456");
    Course course4567 = courseRepository.findCourseByTitle("CS4567");

    university.setAuthorForCourse(facultyAlan, course1234);
    university.setAuthorForCourse(facultyAlan, course2345);
    university.setAuthorForCourse(facultyAda, course3456);
    university.setAuthorForCourse(facultyAda, course4567);

  }

  @Test
  public void testFiveCreateSections() {

    // Sections
    Section sec4321 = new Section("SEC4321", 50);
    Section sec5432 = new Section("SEC5432", 50);
    Section sec6543 = new Section("SEC6543", 50);
    Section sec7654 = new Section("SEC7654", 50);

    university.createSection(sec4321);
    university.createSection(sec5432);
    university.createSection(sec6543);
    university.createSection(sec7654);

    // courses
    Course course1234 = courseRepository.findCourseByTitle("CS1234");
    Course course2345 = courseRepository.findCourseByTitle("CS2345");
    Course course3456 = courseRepository.findCourseByTitle("CS3456");

    //Faculties
    Faculty facultyAlan = facultyRepository.findFacultiesByFirstName("Alan");
    Faculty facultyAda = facultyRepository.findFacultiesByFirstName("Ada");

    // sections
    Section section4321 = sectionRepository.findSectionByTitle("SEC4321");
    Section section5432 = sectionRepository.findSectionByTitle("SEC5432");
    Section section6543 = sectionRepository.findSectionByTitle("SEC6543");
    Section section7654 = sectionRepository.findSectionByTitle("SEC7654");

    // add sections to course
    university.addSectionToCourse(section4321, course1234);
    university.addSectionToCourse(section5432, course1234);
    university.addSectionToCourse(section6543, course2345);
    university.addSectionToCourse(section7654, course3456);

    // add teacher to section
    university.addTeacherToSection(section4321, facultyAlan);
    university.addTeacherToSection(section5432, facultyAlan);
    university.addTeacherToSection(section6543, facultyAlan);
    university.addTeacherToSection(section7654, facultyAda);
  }

  @Test
  public void testSixEnrollStudentsInSections() {

    // students
    Student Alice = studentRepository.findStudentsByFirstName("Alice");
    Student Bob = studentRepository.findStudentsByFirstName("Bob");
    Student Charlie = studentRepository.findStudentsByFirstName("Charlie");

    // Section
    Section section4321 = sectionRepository.findSectionByTitle("SEC4321");
    Section section5432 = sectionRepository.findSectionByTitle("SEC5432");
    Section section6543 = sectionRepository.findSectionByTitle("SEC6543");

    // Add students.
    university.enrollStudentInSection(Alice, section4321);
    university.enrollStudentInSection(Alice, section5432);
    university.enrollStudentInSection(Bob, section5432);
    university.enrollStudentInSection(Charlie, section6543);
  }

  // Validation Tests

  @Test
  public void ValidateUsers() {

    List<Person> personList = personRepository.findAllPersons();

    Assert.assertEquals(9, personList.size());

  }

  @Test
  public void ValidateFaculty() {

    List<Faculty> faculties = facultyRepository.findAllFaculty();

    Assert.assertEquals(2, faculties.size());

  }

  @Test
  public void ValidateStudent() {

    List<Student> students = studentRepository.findAllStudents();

    Assert.assertEquals(7, students.size());

  }

  @Test
  public void ValidateCourses() {

    List<Course> courses = courseRepository.findAllCourses();

    Assert.assertEquals(4, courses.size());

  }

  @Test
  public void ValidateSections() {

    List<Section> sections = sectionRepository.findAllSections();

    Assert.assertEquals(4, sections.size());

  }

  @Test
  public void ValidateCourseAuthorship1() {

    List<Faculty> faculties = facultyRepository.findAllFaculty();

    List<Course> course1 = university.findCoursesForAuthor(faculties.get(0));

    Assert.assertEquals(2, course1.size());

  }

  @Test
  public void ValidateCourseAuthorship2() {

    List<Faculty> faculties = facultyRepository.findAllFaculty();

    List<Course> course2 = university.findCoursesForAuthor(faculties.get(1));

    Assert.assertEquals(2, course2.size());

  }

  @Test
  public void ValidateSectionPerCourse() {

    List<Course> courses = courseRepository.findAllCourses();

    List<Section> section1 = university.findSectionForCourse(courses.get(0));
    List<Section> section2 = university.findSectionForCourse(courses.get(1));
    List<Section> section3 = university.findSectionForCourse(courses.get(2));
    List<Section> section4 = university.findSectionForCourse(courses.get(3));

    Assert.assertEquals(2, section1.size());
    Assert.assertEquals(1, section2.size());
    Assert.assertEquals(1, section3.size());
    Assert.assertEquals(0, section4.size());

  }

  @Test
  public void ValidateSectionEnrollments() {

    List<Section> sections = sectionRepository.findAllSections();

    List<Student> students1 = enrollmentRepository.findStudentForSection(sections.get(0));
    List<Student> students2 = enrollmentRepository.findStudentForSection(sections.get(1));
    List<Student> students3 = enrollmentRepository.findStudentForSection(sections.get(2));
    List<Student> students4 = enrollmentRepository.findStudentForSection(sections.get(3));


    Assert.assertEquals(1, students1.size());
    Assert.assertEquals(2, students2.size());
    Assert.assertEquals(1, students3.size());
    Assert.assertEquals(0, students4.size());


  }

  @Test
  public void ValidateStudentEnrollments() {

    List<Student> students = studentRepository.findAllStudents();

    List<Section> section1 = enrollmentRepository.findSectionForStudent(students.get(0));
    List<Section> section2 = enrollmentRepository.findSectionForStudent(students.get(1));
    List<Section> section3 = enrollmentRepository.findSectionForStudent(students.get(2));
    List<Section> section4 = enrollmentRepository.findSectionForStudent(students.get(3));


    Assert.assertEquals(2, section1.size());
    Assert.assertEquals(1, section2.size());
    Assert.assertEquals(1, section3.size());
    Assert.assertEquals(0, section4.size());


  }

  @Test
  public void ValidateSectionSeats() {

    List<Section> sections = sectionRepository.findAllSections();

    for (Section section : sections) {

      Assert.assertEquals(50, section.getSeats());

    }

  }

}
