# Hospital Management System

A Hospital Management System developed using **Java**, **JSP**, **Servlets**, **Hibernate ORM**, **Maven**, and **MySQL**, implementing complete CRUD operations for Patient, Doctor, Appointment, and Billing management following the MVC (Model-View-Controller) architecture.

---

## Features

### Patient Management
- Add Patient
- View All Patients
- Search Patient by ID
- Update Patient Details
- Delete Patient

### Doctor Management
- Add Doctor
- View All Doctors
- Search Doctor by ID
- Update Doctor Details
- Delete Doctor
- View Available Doctors by Specialization

### Appointment Management
- Book Appointment
- View All Appointments
- Search Appointment
- Update Appointment Details
- Cancel Appointment
- Book appointments with available doctors based on specialization

### Billing Management
- Generate Bill
- View All Bills
- Search Bill
- Mark Bill as Paid
- Automatic Total Amount Calculation using MySQL Generated Columns

---

## Tech Stack

- Java
- JSP (JavaServer Pages)
- Jakarta Servlets
- Hibernate ORM
- Maven
- MySQL
- HTML
- CSS

---

## Architecture

The application follows the MVC (Model-View-Controller) architecture.

```
Browser
    │
    ▼
JSP (View)
    │
    ▼
Servlet (Controller)
    │
    ▼
DAO Layer
    │
    ▼
Hibernate ORM
    │
    ▼
MySQL Database
```

---

## Project Structure

```
HospitalManagementSystem/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.hms.patient
│   │   │   ├── com.hms.doctor
│   │   │   ├── com.hms.appointment
│   │   │   ├── com.hms.billing
│   │   │   ├── com.hms.servlet
│   │   │   └── com.hms
│   │   │
│   │   ├── resources/
│   │   │   └── hibernate.cfg.xml
│   │   │
│   │   └── webapp/
│   │       ├── patient/
│   │       ├── doctor/
│   │       ├── appointment/
│   │       ├── billing/
│   │       └── index.jsp
│
├── pom.xml
└── README.md
```

---

## Database

The application uses MySQL as the relational database.

### Tables

- Patients
- Doctors
- Appointments
- Billing

---

## Hibernate Features Used

- Entity Mapping
- SessionFactory
- Session Management
- Transaction Management
- Hibernate Query Language (HQL)
- CRUD Operations
- Enum Mapping using `@Enumerated`
- Automatic Primary Key Generation

---

## Getting Started

### Prerequisites

- Java 17 or later
- Apache Tomcat 10+
- MySQL 8+
- Maven
- IntelliJ IDEA (Recommended)

### Clone the Repository

```bash
git clone https://github.com/your-username/HospitalManagementSystem.git
```

### Configure the Database

Create the database:

```sql
CREATE DATABASE hospital_sys;
```

Update the database configuration in:

```
src/main/resources/hibernate.cfg.xml
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

Deploy the generated WAR file on Apache Tomcat and open:

```
http://localhost:8080/HospitalManagementSystem
```

---

## Future Enhancements

- User Authentication and Authorization
- Role-Based Access Control
- Hibernate Entity Relationships
- Spring Framework Integration
- Spring Boot Migration
- REST API Development
- Dashboard and Analytics
- Search and Filtering
- Input Validation
- Exception Handling
- Responsive User Interface

---

## Author

**Dharahas Radapu**
