package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  private String label;

  @ManyToOne
  @JsonIgnore
  private Faculty author;

  @OneToMany(mappedBy = "courseSection", cascade = CascadeType.REMOVE)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Section> courseSections;

  public Course(String title) {
    this.label = title;
  }

  public Course() {
  }

  public void setAuthor(Faculty author) {
    this.author = author;
    if (!author.getAuthoredCourses().contains(this)) {
      author.getAuthoredCourses().add(this);
    }
  }

  // head of course section composition
  public void addCourseToSections(Section sections) {
    this.courseSections.add(sections);
    if (sections.getCourseSection() != this)
      sections.setCourseSection(this);
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Faculty getAuthor() {
    return author;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Section> getCourseSections() {
    return courseSections;
  }

  public void setCourseSections(List<Section> courseSections) {
    this.courseSections = courseSections;
  }

}
