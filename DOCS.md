# Modifications
<<<<<<< HEAD
- Created /DB endpoint to display all users in the H2 database (FILE)
=======
- **application.properties**
  - Fixed basic things for H2 database
  - Added DDL settings
- **H2 Database**
  - DB File is now in the project folder (DB)
- **Code**
    - Added a new entity (Movie)
      - Now we can create tables for entities automatically (DDL)
    - Added a new repository (MovieRepository)
      - Now we can use CRUD operations for entities
    - Added a new controller (MovieController)
      - We can make any code with entities (CRUD operations)
---
# Project good to know things
- The project is using H2 database
  - Located in the project folder (DB)
- The project is using Spring Data JPA
- The project is using Spring Web
- The project is using REST API
>>>>>>> 699d3f8689b5a8cb1990324b6b111b2cfe334abb

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