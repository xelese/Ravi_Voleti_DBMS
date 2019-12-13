package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.*;

/**
 * This class contains all the methods that access the database and updates results accordingly.
 */
@Component
public class HospitalManagementDao implements HospitalManagementInterface {

    RestTemplate restTemplate = new RestTemplate();

    // default constructor to initialize the DAO.
    public HospitalManagementDao() {
    }

    // Patient.
    @Autowired
    PatientRepository patientRepository;

    // Doctor.
    @Autowired
    DoctorRepository doctorRepository;

    // App Manager.
    @Autowired
    AppManagerRepository appManagerRepository;

    // Rewards.
    @Autowired
    RewardRepository rewardRepository;

    //Treatment
    @Autowired
    TreatmentRepository treatmentRepository;

    //Feedback
    @Autowired
    FeedbackRepository feedbackRepository;

    // Doctor Condition
    @Autowired
    DoctorConditionRepository doctorConditionRepository;

    // locality
    @Autowired
    LocalityRepository localityRepository;

    // doctor location
    @Autowired
    DoctorLocationRepository doctorLocationRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    DiscountRepository discountRepository;

    @Autowired
    FreeRewardRepository freeRewardRepository;

    @Autowired
    DoctorRewardRepository doctorRewardRepository;

    // FIND.

    @Override
    public List<AppManager> findAllAppManagers() {
        return (List<AppManager>) appManagerRepository.findAll();
    }


    @Override
    public List<Patient> findAllPatientsForLogin() {
        try {
            List<Patient> patients = (List<Patient>) patientRepository.findAll();
            return patients;

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> findAllDoctorsForLogin() {
        try {
            List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();
            return doctors;

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, String> findAllPatients() {
        try {
            List<Patient> patients = (List<Patient>) patientRepository.findAll();
            Map<Integer, String> patientMap = new HashMap<>();
            for (Patient patient : patients) {
                patientMap.put(patient.getId(), patient.getFirstName());
            }

            return patientMap;

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, String> findAllDoctors() {
        try {
            List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();
            Map<Integer, String> doctorMap = new HashMap<>();
            for (Doctor doctor : doctors) {
                doctorMap.put(doctor.getId(), doctor.getFirstName());
            }
            return doctorMap;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, String> findDoctorsByCondition(String condition) {
        Map<String, String> doctorMap = new HashMap<>();
        List<Doctor> doctors = doctorRepository.findDoctorByConditions(condition);
        for (Doctor doctor : doctors) {
            String temp = String.valueOf(doctor.getId());
            for (DoctorLocation locality : doctor.getDoctorLocation()) {
                temp = temp + ":" + locality.getLocality().getName();
                doctorMap.put(temp, doctor.getFirstName());
                temp = String.valueOf(doctor.getId());
            }
        }

        return doctorMap;
    }

    // rewards.
    @Override
    public List<String> findAllRewards() {
        List<Reward> rewards = (List<Reward>) rewardRepository.findAll();
        List<String> rewardList = new ArrayList<>();
        for (Reward reward : rewards) {
            rewardList.add(reward.getDescription());
        }
        return rewardList;
    }

    @Override
    public Map<String, List<String>> findRewardsForDoctorByLocation(Integer doctorId) {
        List<Reward> rewards = rewardRepository.findRewardByDoctorLocation(doctorId);
        List<String> rewardList = new ArrayList<>();
        Map<String, List<String>> returnList = new HashMap<>();
        for (Reward reward : rewards) {
            System.out.println(reward.getDescription());
            rewardList.add(reward.getDescription());
        }
        returnList.put("rewards", rewardList);
        return returnList;
    }

    @Override
    public Map<String, String> findTreatmentsForDoctor(Integer doctor) {
        Map<String, String> appointmentMap = new HashMap<>();
        List<Treatment> treatments = treatmentRepository.findTreatmentForDoctor(doctor);
        int count = 0;
        for (Treatment treatment : treatments) {
            count++;
            appointmentMap.put(count + ". " + treatment.getAppointment().toString(),
                    treatment.getPatient().getFirstName() + ":" + treatment.getLocality().getName());

        }
        return appointmentMap;
    }

    @Override
    public Map<String, String> findTreatmentsForPatient(Integer patient) {
        // AppointmentMap
        Map<String, String> appointmentMap = new HashMap<>();
        List<Treatment> treatments = treatmentRepository.findTreatmentForPatient(patient);
        for (Treatment treatment : treatments) {
            appointmentMap.put(treatment.getAppointment().toString(),
                    treatment.getDoctor().getFirstName() + ":" + treatment.getLocality().getName() + ":" + treatment.getDoctor().getId());
        }
        return appointmentMap;
    }

    @Override
    public List<String> findCondition(String condition) {
        final String uri =
                "https://clinicaltables.nlm.nih.gov/api/conditions/v3/search?terms={term}&df=primary_name&sf=primary_name";
        Map<String, String> params = new HashMap<>();
        params.put("term", condition);
        return getConditionList(restTemplate.getForObject(uri, String.class, params));
    }

    @Override
    public Map<Integer, String> findAllFeedback() {
        Map<Integer, String> feedbackMap = new HashMap<>();
        List<Feedback> feedbacks = feedbackRepository.findFeedbackByAppManager();

        String localityString;
        String doctorString;
        String patientString;

        for (Feedback feedback : feedbacks) {

            Integer rating = ratingRepository.findRatingForFeedback(feedback.getId());

            String review = reviewRepository.findReviewForFeedback(feedback.getId());

            if (rating == null) {
                rating = 0;
            }

            if (review == null) {
                review = "none";
            }

            if (feedback.getLocality() == null) {
                localityString = "none";
            } else {
                localityString = feedback.getLocality().getName();
            }

            if (feedback.getDoctor() == null) {
                doctorString = "none";
            } else {
                doctorString = feedback.getDoctor().getFirstName();
            }

          if (feedback.getPatient() == null) {
            patientString = "none";
          } else {
            patientString = feedback.getPatient().getFirstName();
          }

            feedbackMap.put(feedback.getId(),
                    "rating:" + rating.toString()
                            + " "
                            + "review:" + review
                            + " "
                            + "locality:" + localityString
                            + " "
                            + "doctor:" + doctorString
                            + " "
                            + "patient:" + patientString);
        }

        return feedbackMap;
    }

    // locality
    @Override
    public List<String> findAllLocalities() {
        List<Locality> localities = (List<Locality>) localityRepository.findAll();
        List<String> localityList = new ArrayList<>();
        for (Locality local : localities) {
            localityList.add(local.getName());
        }
        return localityList;
    }

    @Override
    public List<String> findAllLocalitiesForDoctor(Integer doctorId) {
        List<Locality> localities = doctorLocationRepository.findLocationByDoctor(doctorId);
        if (localities != null) {
            List<String> localityList = new ArrayList<>();
            for (Locality local : localities) {
                localityList.add(local.getName());
            }
            return localityList;
        } else {
            return null;
        }
    }
    // CREATE

    @Override
    public boolean createPatient(Patient patient) {
        patientRepository.save(patient);
        return true;
    }


    // doctor.
    @Override
    public boolean createDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return true;
    }

    @Override
    public boolean createDoctorConditions(Integer doctorId, List<String> condition) {
        Doctor doctor = doctorRepository.findById(doctorId).get();

        boolean result = false;
        List<String> conditionList = doctorConditionRepository.findConditionByDoctorId(doctorId);

        for (String cond : condition) {
            if (conditionList.contains(cond)) {
                result = false;
            } else {
                Doctor_Conditions doctorConditions = new Doctor_Conditions(cond);
                doctorConditionRepository.save(doctorConditions);
                doctor.addTreatableCondition(doctorConditions);
                doctorRepository.save(doctor);
                result = true;
            }
        }
        return result;
    }


    @Override
    public boolean createDiscount(Discount discount, String locality, Integer appManagerId) {
        boolean status = false;
        Locality newLocality = localityRepository.findLocalityByName(locality);
        if (newLocality == null) {
            status = false;
        } else {
            Discount newDiscount = discountRepository.save(discount);
            AppManager manager = appManagerRepository.findById(appManagerId).get();
            newDiscount.setManagerReward(manager);
            appManagerRepository.save(manager);
            discountRepository.save(newDiscount);
            localityRepository.save(newLocality);
            newDiscount.setLocality(newLocality);
            discountRepository.save(newDiscount);
            status = true;
        }
        return status;
    }

    @Override
    public boolean createFreeReward(FreeReward freeReward, String locality, Integer appManagerId) {
        boolean status = false;
        Locality newLocality = localityRepository.findLocalityByName(locality);
        if (newLocality == null) {
            status = false;
        } else {
            FreeReward newFreeReward = freeRewardRepository.save(freeReward);
            AppManager manager = appManagerRepository.findById(appManagerId).get();
            newFreeReward.setManagerReward(manager);
            appManagerRepository.save(manager);
            freeRewardRepository.save(freeReward);
            localityRepository.save(newLocality);
            newFreeReward.setLocality(newLocality);
            freeRewardRepository.save(newFreeReward);
            status = true;
        }
        return status;
    }

    @Override
    public boolean createAppointment(Integer doctor, String locality, Integer patientId, Date appointment) {

        Patient newPatient = patientRepository.findById(patientId).get();
        try {
            Doctor newDoctor = doctorRepository.findById(doctor).get();


            Locality location = localityRepository.findLocalityByName(locality);
            if (location == null) {
                return false;
            }
            if (!doctorLocationRepository.findLocationByDoctor(doctor).contains(location)) {
                return false;
            }
            
            Treatment treatment = new Treatment(newDoctor, newPatient, appointment, location);
            treatmentRepository.save(treatment);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean createReviewForDoctor(Review review, Integer patientId, Integer doctorId) {

        try {
            Doctor newDoctor = doctorRepository.findById(doctorId).get();
            Patient newPatient = patientRepository.findById(patientId).get();

            if (!treatmentRepository.findDoctorsForPatient(patientId).contains(doctorId)) {
                return false;
            }

            Review newReview = reviewRepository.save(review);
            newReview.setPatientFeedback(newPatient);
            newReview.setDoctorFeedback(newDoctor);
            reviewRepository.save(newReview);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean createRatingForDoctor(Rating rating, Integer patientId, Integer doctorId) {
        try {
            Doctor newDoctor = doctorRepository.findById(doctorId).get();
            Patient newPatient = patientRepository.findById(patientId).get();

            if (!treatmentRepository.findDoctorsForPatient(patientId).contains(doctorId)) {
                return false;
            }

            Rating newRating = ratingRepository.save(rating);
            newRating.setPatientFeedback(newPatient);
            newRating.setDoctorFeedback(newDoctor);
            ratingRepository.save(newRating);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }

    }

    @Override
    public boolean createReviewForLocality(Review review, Integer patientId, String locality) {
        try {
            Locality newLocality = localityRepository.findLocalityByName(locality);

            if (newLocality == null) {
                return false;
            }

            Patient newPatient = patientRepository.findById(patientId).get();

            if (!treatmentRepository.findLocalityForPatient(patientId).contains(locality)) {
                return false;
            }

            Review newReview = reviewRepository.save(review);
            newReview.setPatientFeedback(newPatient);
            newReview.setLocalityFeedback(newLocality);
            reviewRepository.save(newReview);

            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean createRatingForLocality(Rating rating, Integer patientId, String locality) {

        try {
            Locality newLocality = localityRepository.findLocalityByName(locality);

            if (newLocality == null) {
                return false;
            }

            Patient newPatient = patientRepository.findById(patientId).get();

            if (!treatmentRepository.findLocalityForPatient(patientId).contains(locality)) {
                return false;
            }

            Rating newRating = ratingRepository.save(rating);
            newRating.setPatientFeedback(newPatient);
            newRating.setLocalityFeedback(newLocality);
            ratingRepository.save(newRating);

            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean createLocality(Locality locality) {
        localityRepository.save(locality);
        return true;
    }

    // REGISTER.

    @Override
    public boolean registerReward(List<String> reward, Integer doctorId) {

        boolean status = false;

        Doctor doctor = doctorRepository.findById(doctorId).get();
        for (String description : reward) {
            Reward newReward = rewardRepository.findRewardByDescription(description);
            if (newReward == null) {
                status = false;
            } else {
                if (newReward.getCountOfReward() == 1) {
                    rewardRepository.deleteById(newReward.getId());
                } else {
                    newReward.setCountOfReward(newReward.getCountOfReward() - 1);
                    rewardRepository.save(newReward);
                    DoctorReward doctorReward = new DoctorReward(doctor, newReward);
                    doctorRewardRepository.save(doctorReward);
                }
                status = true;
            }
        }
        return status;
    }

    @Override
    public boolean registerLocality(List<String> locality, Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();

        boolean status = false;
        for (String s : locality) {
            Locality newLocality = localityRepository.findLocalityByName(s);
            if (newLocality == null) {
                status = false;
            } else {
                DoctorLocation doctorLocation = new DoctorLocation(doctor, newLocality);
                doctorLocationRepository.save(doctorLocation);
                doctorRepository.save(doctor);
                localityRepository.save(newLocality);
                status = true;
            }
        }
        return status;
    }

    //UPDATE:

    @Override
    public boolean updateFeedback(Integer managerId, Integer feedbackId) {
        try {
            Feedback feedback = feedbackRepository.findById(feedbackId).get();

            if (feedback == null) {
                return false;
            }

            AppManager appManager = appManagerRepository.findById(managerId).get();

            if (appManager == null) {
                return false;
            }

            feedback.setManagerFeedback(appManager);
            feedbackRepository.save(feedback);

            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean updatePatient(Integer patientId, Patient patient) {
        try {
            Patient newPatient = patientRepository.findById(patientId).get();
            if (patient.getFirstName() != null) {
                newPatient.setFirstName(patient.getFirstName());
            }
            if (patient.getLastName() != null) {
                newPatient.setLastName(patient.getLastName());
            }
            if (patient.getUserName() != null) {
                newPatient.setUserName(patient.getUserName());
            }
            if (patient.getEmail() != null) {
                newPatient.setEmail(patient.getEmail());
            }
            if (patient.getPassword() != null) {
                newPatient.setPassword(patient.getPassword());
            }
            patientRepository.save(newPatient);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean updateDoctor(Integer doctorId, Doctor doctor) {
        try {
            Doctor newDoctor = doctorRepository.findById(doctorId).get();
            if (doctor.getFirstName() != null) {
                newDoctor.setFirstName(doctor.getFirstName());
            }
            if (doctor.getLastName() != null) {
                newDoctor.setLastName(doctor.getLastName());
            }
            if (doctor.getUserName() != null) {
                newDoctor.setUserName(doctor.getUserName());
            }
            if (doctor.getEmail() != null) {
                newDoctor.setEmail(doctor.getEmail());
            }
            if (doctor.getPassword() != null) {
                newDoctor.setPassword(doctor.getPassword());
            }
            doctorRepository.save(newDoctor);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean updateLocality(String oldLocality, Locality locality) {
        try {
            Locality newLocality = localityRepository.findLocalityByName(oldLocality);
            if (newLocality != null) {
                newLocality.setName(locality.getName());
                newLocality.setAddress(locality.getAddress());
                localityRepository.save(newLocality);
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean deletePatient(Integer patientId) {
        Patient patient = patientRepository.findById(patientId).get();

        for (Feedback feedback : patient.getFeedback()) {
            feedback.setPatient(null);
        }

        patientRepository.deleteById(patientId);
        return true;
    }

    @Override
    public boolean deleteDoctor(Integer doctorId) {
        doctorRepository.deleteById(doctorId);
        return true;
    }

    @Override
    public boolean deleteLocalityByDoctor(Integer doctorId, String locality) {

        if (localityRepository.findLocalityByName(locality) == null) {
            return false;
        }
        Locality location = localityRepository.findLocalityByName(locality);

        DoctorLocation doctorLocation = doctorLocationRepository.findDoctorLocation(doctorId, location.getId());

        if (doctorLocation != null) {
            doctorLocationRepository.delete(doctorLocation);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLocalityByAppManager(Integer appManagerId, String locality) {

        if (localityRepository.findLocalityByName(locality) == null) {
            return false;
        }
        Locality location = localityRepository.findLocalityByName(locality);

        localityRepository.deleteById(location.getId());
        return true;
    }

    private List<String> getConditionList(String inputCondition) {
        int position = inputCondition.indexOf("[[");
        String currentCondition = inputCondition.substring(position + 1, inputCondition.length() - 2);
        currentCondition = currentCondition.replaceAll("\\[\"*|\"]*", "");
        return Arrays.asList(currentCondition.split(","));
    }
}
