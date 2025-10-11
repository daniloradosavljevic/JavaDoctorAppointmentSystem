# Java Doctor Appointment System

**Homework for Faculty of Engineering, University of Kragujevac**  
_Class: Designing of Business Applications_


<img width="1770" height="968" alt="zakazivanjetermina" src="https://github.com/user-attachments/assets/ab924c0e-2036-436d-845a-42ea3bd86d67" />

---

## **Project Purpose**

This project demonstrates a complete business application for scheduling doctor appointments, featuring:

- RESTful backend (Spring Boot) with RabbitMQ-based asynchronous processing
- MySQL database for persistent storage
- Modern Bootstrap frontend (GUI)
- API documentation and usage instructions with Postman

The goal is to showcase integration of business logic, asynchronous messaging, and a practical GUI in a business scenario.

---

## **Prerequisites**

Before running the project, make sure you have installed:

1. **Erlang**  
   Needed for RabbitMQ.  
   Download from: https://www.erlang.org/downloads

2. **RabbitMQ Server**  
   Message broker for asynchronous appointment processing.  
   Download from: https://www.rabbitmq.com/download.html

3. **Java (JDK 17+)**  
   For running Spring Boot backend.

4. **XAMPP (MySQL)**  
   For running MySQL database.  
   Download from: https://www.apachefriends.org/download.html

5. **Maven**  
   For building the project.

---

## **Running RabbitMQ**

1. **Install Erlang** and **RabbitMQ Server** (see links above).
2. **Start RabbitMQ service:**
   - On Windows:  
     Open Command Prompt and run  
     ```
     rabbitmq-server start
     ```
     Or use the RabbitMQ Service Manager to start the service.
   - On Linux/Mac:  
     ```
     sudo rabbitmq-server start
     ```
3. **RabbitMQ Management UI** is usually available at [http://localhost:15672](http://localhost:15672)  
   (default user/pass: guest/guest)

---

## **Running MySQL (with XAMPP)**

1. Start **XAMPP Control Panel**
2. Click "Start" for **MySQL** service
3. Database will be available at `localhost:3306`

---

## **Running the Backend Application**

1. **Configure database connection** in `src/main/resources/application.properties`
   - Example:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/appointments_db
     spring.datasource.username=root
     spring.datasource.password=YOUR_PASSWORD
     ```
2. **Build the project:**
   ```
   mvn clean package
   ```
3. **Run as Java Application:**
   - Locate `src/main/java/poslovne/aplikacije/MessagingRabbitmqApplication.java`
   - Right click and select **Run as Java Application** (in Eclipse/IntelliJ)
   - Or from terminal:
     ```
     mvn spring-boot:run
     ```
4. Backend REST API is available at [http://localhost:8080](http://localhost:8080)

---

## **Using the Frontend GUI**

- The `index.html` file is located in `src/main/resources/static/`
- When backend is running, open [http://localhost:8080/index.html](http://localhost:8080/index.html) in your browser
- Features:
  - Schedule new appointments
  - View and filter all appointments
  - See live status updates (automatically refreshed every 5 seconds)

---

## **Using Postman**

- Import API endpoints in Postman to interact with the backend:

### **Create Appointment**
- **POST** `http://localhost:8080/appointments`
- **JSON Body:**
  ```json
  {
    "doctorId": 1,
    "patientId": 2,
    "appointmentTime": "2025-12-01T09:00:00"
  }
  ```
- Response: Appointment object (initial status: PENDING)

### **Get All Appointments**
- **GET** `http://localhost:8080/appointments`
- Response: List of appointments

### **Get Appointments by Status**
- **GET** `http://localhost:8080/appointments?status=CONFIRMED`
- Response: List of filtered appointments

---

## **How the System Works**

- When a new appointment is created, it is sent to RabbitMQ for **asynchronous processing**.
- RabbitMQ consumer validates and updates appointment status (e.g., CONFIRMED).
- The frontend automatically refreshes the appointment list and shows the updated status.
