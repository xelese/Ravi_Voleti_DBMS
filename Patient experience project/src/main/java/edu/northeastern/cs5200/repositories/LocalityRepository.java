package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Locality;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * This interface represents a repository that communicates with locality table.
 */
public interface LocalityRepository extends CrudRepository<Locality, Integer> {

    /**
     * find a location with a given name.
     *
     * @param locality name of the location.
     * @return location name.
     */
    @Query("select l from Locality l where l.name =:locality")
    Locality findLocalityByName(@Param("locality") String locality);
}
