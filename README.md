# 🚗 Smart Parking Management System

A web-based parking management system designed to simplify vehicle management, parking slot booking, and parking administration through a centralized platform.

---

## 📖 Overview

**Smart Parking Management System** is a Java-based web application developed to provide an efficient and organized solution for managing parking facilities.

The system allows users to register, manage their vehicles, check available parking slots, book parking spaces, view booking history, and cancel bookings.

An administrator module is also provided to manage users, parking slots, bookings, and generate parking-related reports.

---

## ✨ Features

### 👤 User Features

* 🔐 User Registration & Login
* 👤 Profile Management
* 🚘 Vehicle Management
* 🅿️ View Available Parking Slots
* 📅 Book Parking Slots
* 📋 View Booking History
* ❌ Cancel Parking Booking
* 🔎 Check Parking Availability

### 👨‍💼 Admin Features

* 📊 Admin Dashboard
* 👥 Manage Users
* 🅿️ Manage Parking Slots
* 📋 Manage Bookings
* 📈 Generate Parking Reports
* 🔎 Monitor Parking Availability
* 🚘 Manage Vehicle Information

---

## 🏗️ Tech Stack

### ☕ Backend

* Java
* J2EE
* JSP
* Servlets
* JDBC

### 🎨 Frontend

* HTML5
* CSS3
* JavaScript

### 🗄️ Database

* MySQL

### 🖥️ Server

* Apache Tomcat

### 🛠️ Development Tools

* Eclipse IDE
* MySQL
* Git
* GitHub

---

## 📁 Project Structure

```text
Smart-Parking-Management-System
│
├── src
│   ├── controller
│   ├── dao
│   ├── model
│   └── ...
│
├── WebContent
│   ├── css
│   ├── js
│   ├── images
│   ├── includes
│   └── *.jsp
│
├── database
│   └── parking_db.sql
│
└── README.md
```

---

## 🔄 Application Workflow

```text
                    ┌──────────────┐
                    │     User     │
                    └──────┬───────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │ Register / Login│
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │ Manage Vehicle  │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │ Check Available  │
                  │ Parking Slots    │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │   Book Slot     │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │ Booking History  │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │ Cancel Booking  │
                  └─────────────────┘
```

---

## 🔐 Authentication

The application provides authentication functionality for secure access to the parking management system.

### Security Features

* User Registration
* User Login
* Session-based Authentication
* Protected User Features
* Separate Admin Module
* Role-based access to administrative functionality

---

## 📦 Main Modules

### 👤 User Module

* Registration
* Login
* Profile Management
* Vehicle Management
* Parking Slot Booking
* Booking History
* Booking Cancellation

### 🅿️ Parking Module

* View Parking Slots
* Check Slot Availability
* Book Parking Slot
* Update Slot Status
* Manage Parking Information

### 👨‍💼 Admin Module

* Admin Login
* User Management
* Parking Slot Management
* Booking Management
* Reports
* Parking Monitoring

---

## 🗄️ Database

The application uses **MySQL** for persistent data management.

### Main Database Entities

```text
User
 │
 ├── Vehicle
 │
 └── Booking
        │
        └── Parking Slot
```

The database stores information related to:

* Users
* Vehicles
* Parking Slots
* Bookings
* Booking Status

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

```text
Java JDK
Apache Tomcat
MySQL
Eclipse IDE
Git
```

### 1️⃣ Clone Repository

```bash
git clone https://github.com/RohitWalke29/Smart-Parking-Management-System.git
```

### 2️⃣ Import Project

Open **Eclipse IDE** and:

1. Select `File`
2. Select `Import`
3. Choose `Existing Projects into Workspace`
4. Select the downloaded project
5. Finish the import

### 3️⃣ Configure MySQL

Create the required database in MySQL and import the project database SQL file.

Update the database connection details in the project's database connection configuration.

### 4️⃣ Configure Apache Tomcat

Add the project to an Apache Tomcat server.

Then:

```text
Right Click Project
       ↓
Run As
       ↓
Run on Server
       ↓
Apache Tomcat
```

### 5️⃣ Run Application

Start the Tomcat server and open the application in your browser.

---

## 📸 Screenshots

Add screenshots of the actual application here.

### 🏠 Home Page

> Add Home Page screenshot

### 🔐 Login Page

> Add Login screenshot

### 👤 User Dashboard

> Add User Dashboard screenshot

### 🚘 Vehicle Management

> Add Vehicle Management screenshot

### 🅿️ Parking Slots

> Add Parking Slot screenshot

### 📅 Slot Booking

> Add Booking screenshot

### 👨‍💼 Admin Dashboard

> Add Admin Dashboard screenshot

### 📊 Reports

> Add Reports screenshot

---

## 🎯 Project Objectives

* 🅿️ Digitize parking management
* 🚘 Simplify vehicle registration and management
* 📅 Provide convenient parking slot booking
* 🔎 Improve parking slot availability tracking
* 📋 Maintain booking history
* 👨‍💼 Provide centralized administration
* 📊 Generate useful parking reports
* ⚡ Reduce manual parking management effort

---

## 🧠 Key Highlights

* 🌐 Java-based web application
* 🏗️ J2EE architecture
* 🔗 JDBC-based database connectivity
* 🗄️ MySQL database integration
* 👤 Separate User and Admin modules
* 🅿️ Real-time parking slot status management
* 📋 Complete booking lifecycle
* 📊 Administrative reporting

---

## 🌱 Future Enhancements

* 📱 Mobile Application
* 📍 GPS-based Parking Location
* 🔔 SMS / Email Notifications
* 💳 Online Parking Payment
* 📷 License Plate Recognition
* 📊 Advanced Parking Analytics
* 🗺️ Interactive Parking Map
* 🔔 Real-time Slot Availability
* ☁️ Cloud Deployment

---

## 📚 What I Learned

Through this project, I gained practical experience in:

* Java web application development
* J2EE architecture
* JSP and Servlet development
* JDBC database connectivity
* MySQL database management
* Session-based authentication
* CRUD operations
* MVC-based application development
* Apache Tomcat deployment
* Designing real-world parking workflows

---

## 👨‍💻 Author

### Rohit Ganesh Walke

**Java Backend Developer | Full-Stack Developer**

* 🔗 GitHub: [RohitWalke29](https://github.com/RohitWalke29)
* 🔗 LinkedIn: [Rohit Walke](https://www.linkedin.com/in/rohit-walke-354b082b1)

---

## ⭐ Show Your Support

If you find this project useful or interesting, consider giving it a ⭐ on GitHub.

---

### 🚀 Built With

**Java • J2EE • JSP • Servlets • JDBC • MySQL • HTML • CSS • JavaScript • Apache Tomcat**
