package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalManagementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin()
public class DeleteController {

    @Autowired
    HospitalManagementDao hospitalManagementDao;

    @DeleteMapping("/delete/patient/{patientId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public boolean deletePatient(@PathVariable("patientId") Integer patientId,
                                 HttpSession session) {
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.deletePatient(patientId);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @DeleteMapping("/delete/doctor/{doctorId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public boolean deleteDoctor(@PathVariable("doctorId") Integer doctorId,
                                HttpSession session) {
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.deleteDoctor(doctorId);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @DeleteMapping("/delete/doctor/locality/{locality}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public boolean deleteLocalityByDoctor(@PathVariable("locality") String locality,
                                          HttpSession session) {
        if (session != null) {
            if (session.getAttribute("type").equals("doctor")) {
                return hospitalManagementDao.deleteLocalityByDoctor(Integer.parseInt(session.getAttribute("id").toString()),
                        locality);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @DeleteMapping("/delete/locality/{locality}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public boolean deleteLocalityByAppManager(@PathVariable("locality") String locality,
                                              HttpSession session) {
        if (session != null) {
            if (session.getAttribute("type").equals("appManager")) {
                return hospitalManagementDao.deleteLocalityByAppManager(Integer.parseInt(session.getAttribute("id").toString()),
                        locality);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}

