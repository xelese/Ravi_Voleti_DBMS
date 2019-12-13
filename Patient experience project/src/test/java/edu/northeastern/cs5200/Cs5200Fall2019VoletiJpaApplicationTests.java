package edu.northeastern.cs5200;

import edu.northeastern.cs5200.daos.HospitalManagementDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class represents test for this application.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Cs5200Fall2019VoletiJpaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    HospitalManagementDao hospitalManagementDao;


    @Test
    public void url() {
        System.out.println(hospitalManagementDao.findDoctorsByCondition("heart"));
        System.out.println(hospitalManagementDao.findDoctorsByCondition("Depression"));
    }
}
