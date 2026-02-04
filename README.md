# NovaCare Medical Center

## Overview

NovaCare is a simple Hospital Management System built with **Java, Spring Boot, Spring Security, Thymeleaf, and MySQL**.
It allows **patients and doctors** to manage appointments, prescriptions, and medical history efficiently.


## Features

* **Patient Management**

  * View and update personal details
  * Book appointments with doctors
  * View medical history and prescriptions

* **Doctor Management**

  * View patient appointments
  * Issue and modify prescriptions
  * Update patient medical history

* **Authentication**

  * Login for patients and doctors
  * Role-based access control

* **Database**

  * MySQL backend with JPA/Hibernate
  * Auto-update schema via `spring.jpa.hibernate.ddl-auto=update`

---

## Tech Stack

* **Backend:** Java 17, Spring Boot 3.x, Spring Security
* **Frontend:** Thymeleaf, Bootstrap 5
* **Database:** MySQL
* **Build Tool:** Maven

---

## Getting Started

### Prerequisites

* Java 17 or higher
* Maven 3.x
* MySQL 8.x
* IDE (IntelliJ IDEA, Eclipse, VS Code)

---

### Setup

1. **Clone the repository**

```bash
git clone https://github.com/BalaganapathiTech/NovaCare-Medical-Center.git
cd NovaCare-Medical-Center
```

2. **Configure database**

* Open `src/main/resources/application.properties`
* Update your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/novacare
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

3. **Build and run the project**

```bash
mvn clean install
mvn spring-boot:run
```

4. **Access the application**

* Open browser: [http://localhost:8080/login](http://localhost:8080/login)
* Login as doctor or patient (predefined in DB or register via UI)

---

## Project Structure

```
src/
 ├─ main/
 │   ├─ java/com/Nova/NovaCare/Medical/Center
 │   │   ├─ Controller
 │   │   ├─ Entity
 │   │   ├─ Repository
 │   │   └─ Security (Spring Security config)
 │   └─ resources/
 │       ├─ templates/       # Thymeleaf HTML pages
 │       ├─ application.properties
 │       └─ static/          # CSS, JS, images
```

---

## Important Notes

* Minimal UI design, focus on backend functionality.
* Thymeleaf forms **must have `th:object`** to bind with entities.
* `appointment.slot` must match `<option value>` type (integer).
* Use `git pull --rebase origin master` to avoid push conflicts.

---

## Author

**Bala Ganapathi** – [GitHub](https://github.com/BalaganapathiTech)
