package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollment")
@IdClass(EnrollmentCompositeKey.class)
public class Enrollment {

  /*@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
*/
  @Id
  @ManyToOne
  @JsonIgnore
  private Student studentEnrolled;

  @Id
  @ManyToOne
  @JsonIgnore
  private Section sectionEnrolled;


  private int grade;
  private String feedback;

  public Enrollment() {
  }

  public Enrollment(Section section, Student student) {
    studentEnrolled = student;
    sectionEnrolled = section;
  }

  public void setEnrolledStudent(Student studentEnrolled) {
    this.studentEnrolled = studentEnrolled;
    if (!studentEnrolled.getStudentEnrollment().contains(this)) {
      studentEnrolled.getStudentEnrollment().add(this);
    }
  }

  public void setEnrolledSections(Section sectionEnrolled) {
    this.sectionEnrolled = sectionEnrolled;
    if (!sectionEnrolled.getSectionEnrollment().contains(this)) {
      sectionEnrolled.getSectionEnrollment().add(this);
    }
  }

  public Student getStudentEnrolled() {
    return studentEnrolled;
  }

  public void setStudentEnrolled(Student studentEnrolled) {
    this.studentEnrolled = studentEnrolled;
  }

  public Section getSectionEnrolled() {
    return sectionEnrolled;
  }

  public void setSectionEnrolled(Section sectionEnrolled) {
    this.sectionEnrolled = sectionEnrolled;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }
}