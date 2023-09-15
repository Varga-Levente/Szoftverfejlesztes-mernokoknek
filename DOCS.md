# Modifications
- Created React App in the project folder (app)
- Added bootstrap@5 react-cookie@4 react-router-dom@6 reactstrap@9 to the React App
- Added proxy line to the package.json in the React App to connect to the Spring Boot app
  - Example fetch request: `fetch('api/...')`
- Modified the default App.js in the React App to display all movies from the database

---
# Java Spring good to know things
- The project is using H2 database
  - Located in the project folder (DB)
- The project is using Spring Data JPA
- The project is using Spring Web
- The project is using REST API

---
# React good to know things
- The React App is located in the project folder (app)
- The React App is using npm (Node Package Manager)
- To start the React app
  - Chnage directory to the app folder
  - Run `npm start`
  - It will start the React app on port 3000
  - It will require to start the Spring Boot app on port 8080 before starting the React app

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