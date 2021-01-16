1) Remote Database - 
The database is relational, hosted on AWS RDS. You could open directly on workbench.
Credentials - 
* host: cs-5200-fall2019-project.cx9jnhwwacro.us-west-2.rds.amazonaws.com
* username: admin
* password: password

The initial values you will find inserted are - 
a) Alice as a patient with username alice and password alice
b) Bob as a doctor with username bob and password bob
c) Admin as the app manager with username admin and password admin
Note - In case you decide to delete users, you can recreate them by signing up new ones directly. You
cannot signup admins though as there is 1 fixed admin(You could manipulate the table directly).

2) Backend Spring JPA server - 
a) Download the backend git repository (https://github.ccs.neu.edu/xelese/cs5200-fall2019-RaviKaizArjun) and run it directly from springboot or maven command line. It MUST run on localhost:8080 only. You may get an sdk error on running it first time, you can choose another java version for the project in that case.

3) Frontend Javascript client -
a) Download the frontend  repository (https://github.ccs.neu.edu/kaiz123/cs5200_project) and directly host the folder on localhost:8000.
b) Go inside the html/ folder on your browser to directly access the index(home) page. Url would look like - 
http://localhost:8000/html/
Continue using the application from there.

Note - The client, server and cross origins have been configured for these ports specifically so make sure you run it on the same ports. In case there is an issue, do reach out.

