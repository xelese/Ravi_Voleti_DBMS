package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalManagementDao;
import edu.northeastern.cs5200.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * This class contains APIs to create different models.
 */
@RestController
@CrossOrigin()
public class CreateController {

    @Autowired
    HospitalManagementDao hospitalManagementDao;

    /**
     * This method creates a patient and returns true. If a patient was not created it returns an error.
     *
     * @param patient is a patient object holding patient data.
     * @return true if created or else an error.
     */
    @PostMapping("/signUp/patient")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createPatient(@RequestBody Patient patient) {
        return hospitalManagementDao.createPatient(patient);
    }


    /**
     * This method create a doctor.
     *
     * @param doc doctor object that holds doctor data.
     * @return true if doctor is created or else throws an error.
     */
    @PostMapping("/signUp/doctor")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createDoctor(@RequestBody Doctor doc) {
        return hospitalManagementDao.createDoctor(doc);
    }

    /**
     * This method creates a doctor for a condition. The String in the map represents "conditions".
     *
     * @param session   contains doctor credentials.
     * @param condition all the conditions that a doctor can treat.
     * @return true if create or else an error or false.
     */
    @PostMapping("/register/doctor/condition")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createDoctorCondition(HttpSession session,
                                         @RequestBody Map<String, List<String>> condition) {
        boolean result;
        if (session != null) {
            if (session.getAttribute("type").equals("doctor")) {
                result = hospitalManagementDao.createDoctorConditions(
                        Integer.parseInt(session.getAttribute("id").toString()),
                        condition.get("conditions"));
            } else {
                result = false;
            }
            return result;
        } else {
            return false;
        }
    }

    /**
     * This method registers doctor for a reward. String in map represents "rewards".
     *
     * @param reward  contains reward details.
     * @param session contains credentials for a doctor.
     * @return true if created or else false/error.
     */
    @PostMapping("/register/doctor/reward")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean signUpReward(@RequestBody Map<String, List<String>> reward,
                                HttpSession session) {
        boolean result;
        if (session != null) {
            if (session.getAttribute("type").equals("doctor")) {
                result = hospitalManagementDao.registerReward(reward.get("rewards"),
                        Integer.parseInt(String.valueOf(session.getAttribute("id"))));
            } else {
                result = false;
            }
            return result;
        } else {
            return false;
        }
    }

    /**
     * This method registers a locality for a doctor. The string in map represents "localities".
     *
     * @param locality contains information to create a locality.
     * @param session  contains doctor credentials.
     * @return true if registered or a false/error.
     */
    @PostMapping("/register/doctor/locality")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean signUpLocality(@RequestBody Map<String, List<String>> locality,
                                  HttpSession session) {
        boolean result;
        if (session != null) {
            if (session.getAttribute("type").equals("doctor")) {
                result = hospitalManagementDao.registerLocality(locality.get("localities"),
                        Integer.parseInt((session.getAttribute("id").toString())));
            } else {
                result = false;
            }
            return result;
        } else {
            return false;
        }
    }

    /**
     * This method registers an appointment for a doctor and a patient. The map string represents a "date".
     *
     * @param doctorId    id of the doctor.
     * @param locality    location of appointment.
     * @param appointment date of appointment.
     * @param session     patient credentials.
     * @return true if created or an error/false.
     */
    @PostMapping("/register/appointment/{doctorId}/{locality}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createAppointment(@PathVariable("doctorId") Integer doctorId,
                                     @PathVariable("locality") String locality,
                                     @RequestBody Map<String, String> appointment,
                                     HttpSession session) {
        boolean status;
        if (session != null) {
            if (session.getAttribute("type").equals("patient")) {
                status = hospitalManagementDao.createAppointment(doctorId, locality,
                        Integer.parseInt(session.getAttribute("id").toString()),
                        Date.valueOf(appointment.get("date")));

            } else {
                status = false;

            }
            return status;
        } else {
            return false;
        }
    }

    /**
     * This method registers a review for a doctor.
     *
     * @param review   details of review.
     * @param doctorId id of the doctor.
     * @param session  patient credentials.
     * @return true if created or else an error/false.
     */
    @PostMapping("/register/review/doctor/{doctorId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createReviewForDoctor(@RequestBody Review review,
                                         @PathVariable("doctorId") Integer doctorId,
                                         HttpSession session) {
        boolean status;
        if (session != null) {
            if (session.getAttribute("type").equals("patient")) {
                status = hospitalManagementDao.createReviewForDoctor(review,
                        Integer.parseInt(session.getAttribute("id").toString()),
                        doctorId);
            } else {
                status = false;

            }
            return status;
        } else {
            return false;
        }
    }

    /**
     * This method registers a rating for a doctor.
     *
     * @param rating   contains details of rating.
     * @param doctorId id of the doctor.
     * @param session  contains patient credentials.
     * @return true if created or else an error/false.
     */
    @PostMapping("/register/rating/doctor/{doctorId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createRatingForDoctor(@RequestBody Rating rating,
                                         @PathVariable("doctorId") Integer doctorId,
                                         HttpSession session) {
        if (session != null) {
            boolean status;
            if (session.getAttribute("type").equals("patient")) {
                status = hospitalManagementDao.createRatingForDoctor(rating,
                        Integer.parseInt(session.getAttribute("id").toString()),
                        doctorId);
            } else {
                status = false;

            }
            return status;
        } else {
            return false;
        }
    }

    /**
     * This method registers a review for a Location.
     *
     * @param review   contains information about review.
     * @param locality location to be reviewed.
     * @param session  credentials of a patient.
     * @return true if created or else an error/false.
     */
    @PostMapping("/register/review/locality/{locality}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createReviewForLocality(@RequestBody Review review,
                                           @PathVariable("locality") String locality,
                                           HttpSession session) {
        boolean status;
        if (session != null) {
            if (session.getAttribute("type").equals("patient")) {
                status = hospitalManagementDao.createReviewForLocality(review,
                        Integer.parseInt(session.getAttribute("id").toString()),
                        locality);

            } else {
                status = false;

            }
            return status;
        } else {
            return false;
        }
    }

    /**
     * This method registers a rating for a doctor.
     *
     * @param rating   contains rating for locality.
     * @param locality location to be rated.
     * @param session  credentials for patient.
     * @return true if created or else an error/false.
     */
    @PostMapping("/register/rating/locality/{locality}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createRatingForLocality(@RequestBody Rating rating,
                                           @PathVariable("locality") String locality,
                                           HttpSession session) {
        boolean status;
        if (session != null) {
            if (session.getAttribute("type").equals("patient")) {
                status = hospitalManagementDao.createRatingForLocality(rating,
                        Integer.parseInt(session.getAttribute("id").toString()),
                        locality);
            } else {
                status = false;

            }
            return status;
        } else {
            return false;
        }
    }

    /**
     * This method registers a discount reward for a locality.
     *
     * @param discount discount details.
     * @param locality location for which discount is to be created.
     * @param session  credentials of app manager.
     * @return true if created or else an error/false.
     */
    @PostMapping("/register/discount/{locality}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createDiscount(
            @RequestBody Discount discount,
            @PathVariable("locality") String locality,
            HttpSession session) {
        boolean status;
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                status = hospitalManagementDao.createDiscount(discount, locality,
                        Integer.parseInt((session.getAttribute("id").toString())));
            } else {
                status = false;

            }
            return status;
        } else {
            return false;
        }
    }

    /**
     * Register a free reward for a locality.
     *
     * @param freeReward details of free reward.
     * @param locality   locality for which a free reward is created.
     * @param session    credentials app manager.
     * @return true if created or else an error/false.
     */
    @PostMapping("/register/free/{locality}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createFreeReward(
            @RequestBody FreeReward freeReward,
            @PathVariable("locality") String locality,
            HttpSession session) {
        boolean status;
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                status = hospitalManagementDao.createFreeReward(freeReward, locality,
                        Integer.parseInt((session.getAttribute("id").toString())));
            } else {
                status = false;

            }
            return status;
        } else {
            return false;
        }
    }

    /**
     * This method creates a localities. Used by an app manager.
     *
     * @param locality locality to be created.
     * @param session  credentials for an app manager.
     * @return true if created or else an error/false.
     */
    @PostMapping("/register/locality")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean createLocality(@RequestBody Locality locality,
                                  HttpSession session) {
        boolean status;
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                hospitalManagementDao.createLocality(locality);
                status = true;
            } else {
                status = false;

            }
            return status;
        } else {
            return false;
        }
    }
}
