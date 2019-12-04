package edu.northeastern.cs5200.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty extends Person {

  // No need of id as it inherits.

  private String office;
  private boolean tenured;

  @OneToMany(mappedBy = "author")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Course> authoredCourses;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "teacher")
  private List<Section> teachesSection;

  public Faculty(String firstName, String lastName, String username, String password,
                 String office, boolean tenured) {
    super(firstName, lastName, username, password);
    this.office = office;
    this.tenured = tenured;
  }

  public Faculty() {
  }

  // faculty section aggregation head
  public void teachesSection(Section section) {
    this.teachesSection.add(section);
    if (section.getTeacher() != this)
      section.setTeachesSection(this);
  }

  // faculty course aggregation head
  public void authoredCourse(Course course) {
    this.authoredCourses.add(course);
    if (course.getAuthor() != this)
      course.setAuthor(this);
  }

  // Getters and setters.

  public List<Course> getAuthoredCourses() {
    return authoredCourses;
  }

  public void setAuthoredCourses(List<Course> authoredCourses) {
    this.authoredCourses = authoredCourses;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public boolean isTenured() {
    return tenured;
  }

  public void setTenured(boolean tenured) {
    this.tenured = tenured;
  }

  public List<Section> getTeachesSection() {
    return teachesSection;
  }

  public void setTeachesSection(List<Section> teachesSection) {
    this.teachesSection = teachesSection;
  }
}
