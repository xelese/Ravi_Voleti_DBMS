#NOTE - There is NO LOADING on ui so please WAIT FOR API CALLS until an alert appears !!!!!

# User Roles:
1. Patient
2. Doctor
3. Admin
# Domain Objects:
1. Feedback
2. Locality
3. Reward
### Details to host
* Host the front end code on port 8000
* Host the server side code on port 8000
# Sign Up User
* Open the index.html to view the sign up page.
* You can choose to be an anonymous user or sign up as a patient or doctor.
* If you choose to sign up, enter the respective details for first name, last name, username, email, password and choose the type of user. Click the "Sign Up" button sign up.
* To verify that a user has been added to the database, you can open the "User" table and find that the user you signed up has been added to the table along with the type of user in the "dtype" column. This verifies a **generalization relationship** between Patient and Doctor.
# Login User
* After signing up, you will be redirected to the login page where you can enter the username, password and choose the type of user. By entering the right credentials, you will be able to login. The front end hits the "/login" api in the back-end where the credential validation is done and accordingly lets you login or throw an error.
### Note
* We are maintaining sessions in our project, therefore, make sure to login to the right type of user to hit the apis the back-end provides.
# Patient
* After logging in as a patient, you will be able to search for conditions, search doctors treating a condition and also see a list of appointments if the patient has any existing appointments.
* You can enter a complete or partial phrase for the condition, say tooth, and you will get a list of conditions that match the entered phrase.
* The front end hits the "/find/{condition}" api to perform the search. The back-end connects to the https://clinicaltables.nlm.nih.gov/apidoc/conditions/v3/doc.html#params api to retrieve a list of conditions that match a phrase and returns the same to the front end.
* After searching for a condition, the patient can enter the condition and retrieve the list of doctors that treat the condition in a particular location. This operation is performed by calling the "/find/doctor/{condition}" api.
* After searching for doctors by condition, the patient can now fix an appointment with any of the displayed doctors by entering an appointment date and clicking the "Make Appointment" button. This operation is performed by calling the "/register/appointment/{doctorId}/{locality}" api.
* When you refresh the page, the patient can now see the appointments that was just created reflect in the list of appointments section. Api responsible for this is "/find/appointment/patient". This can be verified by checking the "Treatment" table for a new record implying the new appointment.
* This establishes a **User-User relationship** between the patient and the doctor.
* In the list of appointments section, the patient can also choose give a feedback for a doctor and a locality. This can be done by simply clicking the "Give feedback for this doctor" or "Give feedback for this location" button.
* A feedback form now appears where the patient can give a review and a rating for a doctor or location. This establishes a **Domain-Domain relationship** and a **One-One relationship** between feedback and rating/review. 
* The patient can submit the feedback by clicking the "Add Feedback" button. This submission is done by hitting one of these apis as per what the patient chose: "/register/review/doctor/{doctorId}", "/register/rating/doctor/{doctorId}", "/register/review/locality/{locality}", "/register/rating/locality/{locality}".
* This can be verified by viewing the "Feedback" table and noticing the rating/review you had given. It also tests the  **User-Domain relationship** and **One-Many relationship** between the patient and the feedback.
* We felt that it does not make sense for the patient to update or delete a feedback. Hence, the patient (User) can only perform create operation on the feedback (domain object).
# Doctor
* After logging in as a doctor, you will be able to register for conditions you want to treat, register for locations you are willing to treat patients in and register for rewards available in this doctor's signed up localities.
* The doctor can also view a list of appointments fixed by patients. This enforces the **User-User relationship** and **Many-Many relationship** between Doctor and Patient.
* You can register for conditions by clicking the "Register for Conditions" button and entering the condition, say tuberculosis, you want to treat. Api involved for this operation is "/register/doctor/condition". 
* This can tested by viewing the "doctor_condition" table and noticing tuberculosis being added for that doctor. It can also be tested by logging in as a patient and searching for doctor by tuberculosis. You will retrieve a list of doctors which would include the doctor you logged in as.
* You can register for different locations you want to treat patients at. This can be done by clicking the "Register for Locations" button. A list of locations will be provided (by hitting "/find/locality" api) where you can select the locations you want, say Khoury. (by hitting "/register/doctor/locality" api). A doctor is invisible to patients until he signs up for atleast one location to practice in. 
* This establishes the **User-Domain relationship** and **Many-Many relationship** between doctor and location.
* This can verified by viewing the "doctor_location" mapping table and noticing Khoury being added for that doctor. It can also be tested by logging in as a patient and searching for doctor by tuberculosis. You will retrieve a list of doctors which would include the doctor you logged in as which also shows the location he treats in.
* You can delete a locality for which you registered by clicking the "Delete Locality" button. This will list the localities you have registered for (by calling "/find/locality/doctor" api) and then you can delete the locality to be deleted (by calling "/delete/doctor/locality/{locality}" api). Note that you cannot delete a locality for which there is an existing appointment.
* You can also register for a reward. Rewards are of two types: Discount coupon and Free reward. This establishes a **Domain-Domain relationship** and a **One-One relationship** between Reward and discount/free reward.
* After registering for locations, a list of rewards will appear to the doctor as each reward is based off a location by calling the "/find/reward/location/doctor" api. This establishes a **Domain-Domain relationship** and **Many-One relationship** between Reward and location.
* You can register for the reward by clicking the signup button. This confirms a **User-Domain relationship** and **Many-Many relationship** between doctor and reward.
* This can verified by viewing the "doctor_reward" table and noticing reward you registered for.
# Admin
* After logging in as an admin, you can exercise CRUD operations on the users, i.e, Patient and Doctor. You can also create rewards, create localities, delete localities and mark feedbacks as seen.
* You can create a patient or doctor directly from the sign up page.
* Click "update/delete patient" or "update/delete doctor" button to update/delete a patient or doctor.
* On clicking these buttons, you will be able to see a list of patients or doctors (by calling "/find/patient" or "/find/doctor" api). You can click the update or delete button next to each doctor or patient to update or delete (by calling one of "/update/patient/{patientId}", "/update/doctor/{doctorId}", "/delete/patient/{patientId}", "/delete/doctor/{doctorId}").
* On refreshing the page, you can see the updates/deletes reflecting.
* Admin can review a feedback by clicking the "mark as seen" button on the lists of all feedback given by patients (by calling "/find/feedback/appManager" api). On clicking the "mark as seen", a feedback is marked as read, and next time the admin reviews the feedback, the marked feedback will not appear (by calling "/update/feedback/{feedbackId}" api). This can be verified by marking a feedback as seen and then refreshing the page to see the marked feedback not appear in the list of feedback.
* Admin can create rewards by navigating the reward section. Then, the admin needs to enter a description, number of rewards and type of reward. Upon clicking "add new reward" button, the reward will be created and can be verified by checking for the new entry in the "reward" table.
* The admin can also create localities using "update/delete locality" button. This can be done by navigating to the location section and entering a name and address which then hits the "/register/locality" api and then clicking the "add new location" button. This can verified by checking the "locality" table for the new entry added.
* It is possible to update and delete the locality by clicking the respective buttons. These buttons accordingly call the "/update/locality/{locality}", "/delete/locality/{locality}" api. This can be verified by checking the locality and noticing the changed made.

#NOTE - There is NO LOADING on ui so please WAIT FOR API CALLS until an alert appears !!!!!