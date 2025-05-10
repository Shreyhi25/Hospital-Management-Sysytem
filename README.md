## This README includes:

1. Clear project description
2. Comprehensive feature list
3. Database schema details
4. Installation instructions
5. Usage guidelines
6. Technical specifications
7. Future enhancement ideas
8. Contribution guidelines

# Hospital Management System

A Java-based console application for managing hospital operations including patient registration, doctor management, and appointment scheduling.

## Features

- **Patient Management**
  - Add new patients with validation (name, age, gender)
  - View all patients in a formatted table
  - Check patient existence by ID

- **Doctor Management**
  - View all doctors with their specializations
  - Check doctor existence by ID

- **Appointment System**
  - Book appointments with date validation (YYYY-MM-DD format)
  - Check doctor availability
  - Prevent duplicate appointments

## Database Schema

The system uses MySQL with the following tables:

### Patients Table : 
```sql
CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL
);
```

### Doctors Table : 
```sql

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialization VARCHAR(255) NOT NULL
);
```

### Appointments Table :
```sql

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
```
## Database Schema Screenshot
![Image](https://github.com/user-attachments/assets/d9ae8db2-e343-46c7-8d7b-29750c301ebb) 

## Installation

### 1. Prerequisites
- Java JDK 8 or later
- MySQL Server
- MySQL Connector/J (included in project)

### 2. Setup Database

```sql
CREATE DATABASE hospital;
USE hospital;
```
Then create the tables using the schema above.

### 3. Configure Database Connection
Edit the connection details in HospitalManagementSystem.java:
```sql
private static final String url = "jdbc:mysql://localhost:3306/hospital";
private static final String username = "root";
private static final String password = "root"; // Change to your MySQL password
```
### 4. Run the Application
```sql
javac HospitalManagementSystem.java
java HospitalManagementSystem
```

## Usage
### 1. Main Menu Options

1. Add Patient
2. View Patient
3. View Doctor
4. Book Appointment
5. Exit
   
### 2. Input Validation

- Patient name: Only alphabets and spaces
- Age: Numbers between 1-119
- Gender: Only "male" or "female"
- Date: Strict YYYY-MM-DD format

### Output ScreenShots

- Add Patient

![Image](https://github.com/user-attachments/assets/17be2659-3c69-4428-b429-e34d8a5f4f2e)

- View Patient

![Image](https://github.com/user-attachments/assets/08abfce9-daac-4c21-b868-4b4c8b9c31cf)


- View Doctor

![Image](https://github.com/user-attachments/assets/8981d61c-f537-4816-a6f5-72b6b8fe9199)

- Book Appointment

![Image](https://github.com/user-attachments/assets/679f87e6-1e59-4a04-889f-e0b2f11c9e4d)

- Exit 

![Image](https://github.com/user-attachments/assets/ba2407d9-6f07-41b6-91af-c3a4a5f70fff)


## Technical Details
- Language: Java
- Database: MySQL
- JDBC Driver: MySQL Connector/J
- Design Pattern: MVC (Model-View-Controller) approach

## Future Enhancements

- Add prescription management
- Implement user authentication
- Add billing system
- Develop graphical user interface

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.







