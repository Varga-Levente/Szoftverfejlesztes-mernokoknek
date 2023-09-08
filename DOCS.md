# Modifications
- Created a PostMapping to add a new movie to database

---
# Project good to know things
- The project is using H2 database
  - Located in the project folder (DB)
- The project is using Spring Data JPA
- The project is using Spring Web
- The project is using REST API

---
# Access to H2 Database
- **URL**: http://localhost:8080/h2-console
- **JDBC URL**: jdbc:h2:file:./DB
- **Username**: sa
- **Password**: password
- **Driver Class**: org.h2.Driver
- **Dialect**: org.hibernate.dialect.H2Dialect

---
# Project structure
- src/main/java/com.unideb.sfm.Szoftverfejlesztesmernokoknek
  - **controller**
    - _Contains the controllers for the REST API_
  - **model**
    - _Contains the entities for the database and the whole project_
  - **repository**
    - _Contains the repositories for the entities_
  - **service**
    - _Contains the services for the entities_