package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents a repository that communicates with a patient part of user table.
 */
public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
