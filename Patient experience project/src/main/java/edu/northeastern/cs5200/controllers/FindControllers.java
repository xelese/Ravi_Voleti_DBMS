package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalManagementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * This class contains API's to find details about different models.
 */
@RestController
@CrossOrigin()
public class FindControllers {

    @Autowired
    HospitalManagementDao hospitalManagementDao;

    /**
     * This method finds all the patients.
     *
     * @return list of all patients.
     */
    @GetMapping("/find/patient")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Map<Integer, String> findAllPatients(HttpSession session) throws Exception {
        if (session.getAttribute("type").equals("appManager")) {
            return hospitalManagementDao.findAllPatients();
        } else {
            throw new Exception("invalid login");
        }
    }

    @GetMapping("/find/doctor")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Map<Integer, String> findAllDoctors(HttpSession session) throws Exception {
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.findAllDoctors();
            } else {
                throw new Exception("invalid login");
            }
        } else {
            throw new Exception("invalid session");
        }
    }

    /**
     * This method returns a list of all descriptions for rewards.
     *
     * @return list of descriptions for reward.
     */
    @GetMapping("/find/rewards")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public List<String> findRewards() {
        return hospitalManagementDao.findAllRewards();
    }

    /**
     * This method returns a map of doctor and conditions.
     *
     * @param condition condition to be searched by.
     * @return list of all doctors for a condition.
     */
    @GetMapping("/find/doctor/{condition}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Map<String, String> findDoctorByCondition(@PathVariable("condition") String condition) {
        return hospitalManagementDao.findDoctorsByCondition(condition);
    }

    /**
     * This method finds all the conditions from a remote API. Can return even when condition is given as partial input.
     *
     * @param condition conditions to search by.
     * @return all the conditions matching the condition string.
     */
    @GetMapping("/find/{condition}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public List<String> findConditions(@PathVariable("condition") String condition) {
        return hospitalManagementDao.findCondition(condition);
    }

    /**
     * This method finds rewards for a doctor.
     *
     * @param session contains doctor credentials.
     * @return list of rewards by location.
     */
    @GetMapping("/find/reward/location/doctor")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Map<String, List<String>> findRewardForDoctor(HttpSession session) throws Exception {

        if (session != null) {
            if (session.getAttribute("type").equals("doctor")) {
                Integer doctorId = Integer.parseInt(session.getAttribute("id").toString());
                return hospitalManagementDao.findRewardsForDoctorByLocation(doctorId);
            } else {

                // if null its not a doctor.
                throw new IllegalStateException("incorrect access");
            }
        } else {
            throw new Exception("invalid session");
        }
    }

    /**
     * This method finds appointment for a doctor.
     *
     * @param session contains information about doctor.
     * @return list of appointments for a doctor.
     */
    @GetMapping("/find/appointment/doctor")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Map<String, String> findAppointmentForDoctor(HttpSession session) throws Exception {
        if (session != null) {
            if (session.getAttribute("type").equals("doctor")) {
                Integer doctorId = Integer.parseInt(session.getAttribute("id").toString());
                return hospitalManagementDao.findTreatmentsForDoctor(doctorId);
            } else {
                throw new IllegalStateException("incorrect access");
            }
        } else {
            throw new Exception("invalid session");
        }
    }

    /**
     * This method finds appointment for a patient.
     *
     * @param session contains information about patient.
     * @return appointments for a patient.
     */
    @GetMapping("/find/appointment/patient")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Map<String, String> findAppointmentForPatient(HttpSession session) throws Exception {
        if (session != null) {
            if (session.getAttribute("type").equals("patient")) {
                Integer patientId = Integer.parseInt(session.getAttribute("id").toString());
                return hospitalManagementDao.findTreatmentsForPatient(patientId);
            } else {
                // if null its not a doctor.
                throw new IllegalStateException("incorrect access");
            }
        } else {
            throw new Exception("invalid session");
        }
    }

    /**
     * finds all feedback for an app manager.
     *
     * @param session contains details about app manager.
     * @return feedback for app managers.
     * @throws Exception if invalid login is detected.
     */
    @GetMapping("/find/feedback/appManager")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Map<Integer, String> findAllFeedbackForAppManager(HttpSession session) throws Exception {

        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.findAllFeedback();
            } else {
                throw new Exception("Wrong type of Login");
            }
        } else {
            throw new Exception("invalid session");
        }
    }

    /**
     * This method finds all localities.
     *
     * @param session credentials of a doctor.
     * @return all locations.
     * @throws Exception if invalid login is detected.
     */
    @GetMapping("/find/locality")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public List<String> findAllLocalities(HttpSession session) throws Exception {
        if (session != null) {
            if (session.getAttribute("type").equals("doctor")
                    || session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.findAllLocalities();
            } else {
                throw new Exception("error you are not a doctor.");
            }
        } else {
            throw new Exception("invalid session");
        }
    }

    @GetMapping("/find/locality/doctor")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public List<String> findAllLocalitiesForDoctor(HttpSession session) throws Exception {
        if (session != null) {
            if (session.getAttribute("type").equals("doctor")) {
                return hospitalManagementDao.findAllLocalitiesForDoctor(Integer.parseInt(session.getAttribute("id").toString()));
            } else {
                throw new Exception("error you are not a doctor.");
            }
        } else {
            throw new Exception("invalid session");
        }
    }

}
