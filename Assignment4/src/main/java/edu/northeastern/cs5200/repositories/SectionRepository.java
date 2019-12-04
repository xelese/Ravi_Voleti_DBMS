package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

public interface SectionRepository extends CrudRepository<Section, Integer> {

  @Query("SELECT s FROM Section s")
  public List<Section> findAllSections();

  /*@Query("SELECT s FROM Section s WHERE s.student=:student")
  List<Section> findStudentsInSection(@Param("student") Student student);
  */

  @Query("SELECT section FROM Section section WHERE section.title=:title")
  public Section findSectionByTitle(@Param("title") String title);

}
