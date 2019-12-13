package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * This interface repents the operations that are called when an API is executed.
 */
public interface HospitalManagementInterface {

    /**
     * finds all patients.
     *
     * @return list of patients.
     */
    Map<Integer, String> findAllPatients();

    List<Patient> findAllPatientsForLogin();

    /**
     * finds all app manager.
     *
     * @return list of managers.
     */
    List<AppManager> findAllAppManagers();

    /**
     * finds all doctors
     *
     * @return list of all doctors.
     */
    Map<Integer, String> findAllDoctors();

    List<Doctor> findAllDoctorsForLogin();

    /**
     * finds doctor for conditions.
     *
     * @param condition to be searched for.
     * @return the list of doctors.
     */
    Map<String, String> findDoctorsByCondition(String condition);

    /**
     * finds all rewards.
     *
     * @return list of rewards.
     */
    List<String> findAllRewards();

    /**
     * finds rewards for doctor by location.
     */
    Map<String, List<String>> findRewardsForDoctorByLocation(Integer doctorId);

    /**
     * find the treatments for a doctor.
     *
     * @param doctor details of the doctor.
     * @return list of treatments.
     */
    Map<String, String> findTreatmentsForDoctor(Integer doctor);

    /**
     * This method finds treatment for a doctor.
     *
     * @param patient patient to be added to treatment.
     * @return list of treatments and detail;
     */
    Map<String, String> findTreatmentsForPatient(Integer patient);

    /**
     * This method finds conditions with a given input.
     *
     * @param condition condition input to be searched by on the remote api.
     * @return list of names of condition.
     */
    List<String> findCondition(String condition);

    /**
     * finds all feedback.
     *
     * @return list of all feedback names.
     */
    Map<Integer, String> findAllFeedback();

    /**
     * finds all localities.
     *
     * @return list of all localities.
     */
    List<String> findAllLocalities();

    List<String> findAllLocalitiesForDoctor(Integer doctorId);

    /**
     * creates a patient.
     *
     * @param patient patient details.
     * @return true if created.
     */
    boolean createPatient(Patient patient);

    /**
     * creates a doctor.
     *
     * @param doctor doctor details.
     * @return true if created.
     */
    boolean createDoctor(Doctor doctor);

    /**
     * creates a discount for a given locality.
     *
     * @param discount     discount details.
     * @param locality     locality name.
     * @param appManagerId id if the app manager.
     * @return true if created a discount.
     */
    boolean createDiscount(Discount discount, String locality, Integer appManagerId);

    /**
     * creates a free reward for a given locality.
     *
     * @param freeReward   details of free reward.
     * @param locality     locality name.
     * @param appManagerId id of the manager.
     * @return true if created.
     */
    boolean createFreeReward(FreeReward freeReward, String locality, Integer appManagerId);

    /**
     * creates an appointment between a doctor and a patient.
     *
     * @param doctor      doctor details.
     * @param locality    locality name.
     * @param patientId   patient id.
     * @param appointment date of appointment.
     * @return true if created.
     */
    boolean createAppointment(Integer doctor, String locality, Integer patientId, Date appointment);

    /**
     * creates a review for a doctor.
     *
     * @param review    review details.
     * @param patientId patient id.
     * @param doctorId  doctor id.
     * @return true if created.
     */
    boolean createReviewForDoctor(Review review, Integer patientId, Integer doctorId);

    /**
     * creates a rating for a doctor.
     *
     * @param rating    rating details.
     * @param patientId patient details.
     * @param doctorId  doctor id.
     * @return true if created.
     */
    boolean createRatingForDoctor(Rating rating, Integer patientId, Integer doctorId);

    /**
     * creates a review for a doctor.
     *
     * @param review    review details.
     * @param patientId patient id.
     * @param locality  locality to be reviewed.
     * @return true if created.
     */
    boolean createReviewForLocality(Review review, Integer patientId, String locality);

    /**
     * creates a rating for a doctor.
     *
     * @param rating    rating details.
     * @param patientId patient details.
     * @param locality  locality to be reviewed.
     * @return true if created.
     */
    boolean createRatingForLocality(Rating rating, Integer patientId, String locality);

    /**
     * creates a locality.
     *
     * @param locality locality details.
     * @return true if created.
     */
    boolean createLocality(Locality locality);

    /**
     * creates a doctor condition.
     *
     * @param doctor    doctor id.
     * @param condition conditions treatable by this doctor.
     * @return true if created.
     */
    boolean createDoctorConditions(Integer doctor, List<String> condition);

    /**
     * registers a locality to a doctor.
     *
     * @param locality locality to be registered.
     * @param doctorId doctor id.
     * @return true if created.
     */
    boolean registerLocality(List<String> locality, Integer doctorId);

    /**
     * registers a reward to a doctor.
     *
     * @param reward   reward to be registered.
     * @param doctorId doctor id.
     * @return returns true if registered.
     */
    boolean registerReward(List<String> reward, Integer doctorId);

    /**
     * updates the app manager for a feedback.
     *
     * @param managerId  app manager details.
     * @param feedbackId feedback id to be updated.
     * @return true if registered.
     */
    boolean updateFeedback(Integer managerId, Integer feedbackId);

    boolean updatePatient(Integer patientId, Patient patient);

    boolean updateDoctor(Integer patientId, Doctor doctor);

    boolean updateLocality(String oldLocality, Locality locality);

    boolean deletePatient(Integer patientId);

    boolean deleteDoctor(Integer doctorId);

    boolean deleteLocalityByDoctor(Integer doctorId, String locality);

    boolean deleteLocalityByAppManager(Integer appManagerId, String locality);

}
