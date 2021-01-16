Welcome to the cs5200-fall2019-RaviKaizArjun project wiki!

**DBMS PROJECT - 3**

**Problem Statement** - 
In today’s world with an increase in the discovery of medical conditions of many kinds, there are also many specific treatments available. These treatments may be available in many locations and vary in cost, effectiveness, and specificity. However, there are very few ways in which a person (potential patient) can have a personalized experience where he/she can search for potential doctors that treat specific conditions in a specific way and at a specific cost. There is a need for a personalized patient experience allowing targeted search, details and even feedback. Along with just plain knowledge, patients should remain motivated to use a system so that they have a long term benefit.


 **Proposed Solution** - 
Our proposed solution is to create a system(a web app in our case), where patients, doctors, and system(app manager) managers all collaborate on the same data. A doctor treats a patient and a system manager is responsible for maintaining the app, that is, working on feedback, improving patient experience and creating Rewards. Patients are motivated to have a long term relation with this system by means of rewards, which also help to promote doctors.


**Users, Objects and Relations** -
1) Human Users - Doctor, Patient, App Manager(admin).
2) Domain objects - Feedback, Reward, Locality.
3) User - User relations - 
* Doctor treats a patient.
* Doctor signs up for rewards created by the App Manager.
* Patient is treated by a Doctor.
* Patient gives feedback for the App Manager to improve the app.
* App Manager reviews the feedback given by the patients.
* App manager creates rewards for the doctors.
4) User - Domain relations - 
* Patient gives Feedback.
* Patient has a Condition.
* Doctor treats a Condition.
* Doctor signs up for Rewards.
* App Manager reviews Feedback.
* App Manager creates Rewards.
5) Domain - Domain Relations -
* Feedback is given for a Locality.
* Feedback has a review and rating.
* Locality has many feedback.
* Locality can have many rewards associated with it.
* Reward is given for a Locality.
* Rewards has a Discount coupon or Free reward.

**API** -
The BetterDoctor API helps in matching patients with doctors. It already contains doctor's data, the conditions they treat and their locations. It contains other data that we ignore for this project. As their Doctor search API is crashing at the moment, we have used their Condition search API which returns a list of conditions given an input. This API is used directly for real-time searching of conditions by the patient. Using this, data our own mapping tables are populated and use cases are fulfilled with this data itself. 

**CLASS DIAGRAM**
![CLASS DIAGRAM PROJECT](https://i.imgur.com/qYv0Tsq.png)

**SEQUENCE DIAGRAM**
![Sequence Diagram](https://i.imgur.com/NtvWYII.png)


