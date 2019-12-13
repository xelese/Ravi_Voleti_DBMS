package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalManagementDao;
import edu.northeastern.cs5200.models.Doctor;
import edu.northeastern.cs5200.models.Locality;
import edu.northeastern.cs5200.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin()
public class UpdateController {

    @Autowired
    HospitalManagementDao hospitalManagementDao;


    @PutMapping("/update/patient/{patientId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean updatePatient(HttpSession session,
                                 @PathVariable("patientId") Integer patientId,
                                 @RequestBody Patient patient) {
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.updatePatient(patientId, patient);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @PutMapping("/update/locality/{locality}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean updateLocalityForAppManager(HttpSession session,
                                               @PathVariable("locality") String oldLocality,
                                               @RequestBody Locality locality) {
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.updateLocality(oldLocality, locality);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @PutMapping("/update/doctor/{doctorId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean updateDoctor(HttpSession session,
                                @PathVariable("doctorId") Integer doctorId,
                                @RequestBody Doctor doctor) {
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.updateDoctor(doctorId, doctor);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * This method updates feedback for a doctor.
     *
     * @param session    credentials for an app manager.
     * @param feedbackId feedback for which app manager needs to be updated.
     * @return true if created or else an error/false.
     */
    @PutMapping("/update/feedback/{feedbackId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean updateFeedback(HttpSession session,
                                  @PathVariable("feedbackId") Integer feedbackId) {
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                hospitalManagementDao.updateFeedback(Integer.parseInt(session.getAttribute("id").toString()),
                        feedbackId);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
