package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalManagementDao;
import edu.northeastern.cs5200.models.AppManager;
import edu.northeastern.cs5200.models.Doctor;
import edu.northeastern.cs5200.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * This class contains core operations such as login / logout.
 */
@RestController
@CrossOrigin()
public class HospitalManagementController {

    @Autowired
    HospitalManagementDao hospitalManagementDao;

    /**
     * Logs in a user of type patient, doctor or an appManager.
     *
     * @param username username of the user.
     * @param password password of the user.
     * @param type     type of user.
     * @param session  credentials from cookies.
     * @return true if correct or else an error/ false.
     */
    @GetMapping("/login")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Boolean login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("type") String type,
                         HttpSession session) {
        try {
            // patient validation.
            if (type.equals("patient")) {
                for (Patient patient : hospitalManagementDao.findAllPatientsForLogin()) {
                    if (patient.getUserName().equals(username)
                            && patient.getPassword().equals(password)) {
                        session.setAttribute("type", type);
                        session.setAttribute("id", patient.getId());
                        return true;
                    }
                }
            }
            // doctor validation.
            else if (type.equals("doctor")) {
                for (Doctor doctor : hospitalManagementDao.findAllDoctorsForLogin()) {
                    if (doctor.getUserName().equals(username)
                            && doctor.getPassword().equals(password)) {
                        session.setAttribute("type", type);
                        session.setAttribute("id", doctor.getId());
                        return true;
                    }
                }
            }
            // appManager validation.
            else if (type.equals("appManager")) {
                for (AppManager appManager : hospitalManagementDao.findAllAppManagers()) {
                    if (appManager.getPassword().equals(password)
                            && appManager.getUsername().equals(username)) {
                        session.setAttribute("type", type);
                        session.setAttribute("id", appManager.getId());
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method logs out of the session.
     *
     * @param session details of the session.
     * @return invalidates a session.
     */
    @GetMapping("/logout")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public boolean logout(HttpSession session) {
        session.invalidate();
        return true;
    }
}