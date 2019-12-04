package edu.northeastern.cs5200.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Student extends Person {
  private int gradYear;
  private long scholarship;


  @OneToMany(mappedBy = "studentEnrolled")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Enrollment> studentEnrollment;


  public Student(String firstName, String lastName, String username, String password, int gradYear, long scholarship) {
    super(firstName, lastName, username, password);
    this.gradYear = gradYear;
    this.scholarship = scholarship;
  }

  public Student() {
  }

  public void studentsEnrolled(Enrollment enrollment) {
    this.studentEnrollment.add(enrollment);
    if (enrollment.getStudentEnrolled() != this)
      enrollment.setEnrolledStudent(this);
  }

  public List<Enrollment> getStudentEnrollment() {
    return studentEnrollment;
  }

  public void setStudentEnrollment(List<Enrollment> studentEnrollment) {
    this.studentEnrollment = studentEnrollment;
  }

  public int getGradYear() {
    return gradYear;
  }

  public void setGradYear(int gradYear) {
    this.gradYear = gradYear;
  }

  public long getScholarship() {
    return scholarship;
  }

  public void setScholarship(long scholarship) {
    this.scholarship = scholarship;
  }
}

