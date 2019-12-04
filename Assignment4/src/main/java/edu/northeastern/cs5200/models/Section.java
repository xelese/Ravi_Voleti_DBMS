package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private int seats;
  private String title;

  @OneToMany(mappedBy = "sectionEnrolled")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Enrollment> sectionEnrollment;

  @ManyToOne
  @JsonIgnore
  private Course courseSection;

  @ManyToOne
  @JsonIgnore
  private Faculty teacher;

  public Section(String title, int seats) {
    this.title = title;
    this.seats = seats;
  }

  public Section() {
  }

  public void studentsEnrolled(Enrollment enrollment) {
    this.sectionEnrollment.add(enrollment);
    if (enrollment.getSectionEnrolled() != this)
      enrollment.setEnrolledSections(this);
  }

  // tail of faculty section aggregation
  public void setTeachesSection(Faculty faculty) {
    this.teacher = faculty;
    if (!faculty.getTeachesSection().contains(this)) {
      faculty.getTeachesSection().add(this);
    }
  }

  // tail of course section composition
  public void addSectionToCourse(Course course) {
    this.courseSection = course;
    if (!course.getCourseSections().contains(this)) {
      course.getCourseSections().add(this);
    }
  }

  public int getSeats() {
    return seats;
  }

  public void setSeats(int seats) {
    this.seats = seats;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Enrollment> getSectionEnrollment() {
    return sectionEnrollment;
  }

  public void setSectionEnrollment(List<Enrollment> sectionEnrollment) {
    this.sectionEnrollment = sectionEnrollment;
  }

  public Course getCourseSection() {
    return courseSection;
  }

  public void setCourseSection(Course courseSection) {
    this.courseSection = courseSection;
  }

  public Faculty getTeacher() {
    return teacher;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setTeacher(Faculty teacher) {
    this.teacher = teacher;
  }
}
