# Employee Management System

## Overview
The Employee Management System is a web-based application developed using **Java Servlets** that facilitates CRUD (Create, Read, Update, Delete) operations on employee records. This system provides an efficient way to manage employee data, including adding new employees, updating existing records, viewing employee details, and deleting records when needed.

## Features
- Add new employees with details such as name, designation, department, and salary.
- Update existing employee records.
- View a list of all employees.
- Delete employee records.
- User-friendly web interface for seamless interaction.

## Tech Stack
- **Backend**: Java Servlets, JDBC
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Server**: Apache Tomcat 9.0.46
- **IDE**: Eclipse

## Installation & Setup
### Prerequisites
- Java Development Kit (JDK 8 or later)
- Apache Tomcat 9.0.46
- MySQL Server
- Eclipse IDE

### Steps to Run the Project
1. Clone the repository or download the project files.
2. Open Eclipse and import the project.
3. Set up the database:
   - Create a MySQL database (e.g., `employee_db`).
   - Create a 'MyConnection.properties' on your desktop.
   - write in 'MyConnection.properties'.
   - 
      <img width="224" alt="image" src="https://github.com/user-attachments/assets/3252c777-9ef6-45a2-8b65-06483a2a072d" />

4. Configure the database connection in `DBConnection.java`.
5. Deploy the project on Apache Tomcat.
6. Run the application and access it via `http://localhost:8080/EmployeeManagement`.

## Database Schema
**Empl:**
-
<img width="406" alt="image" src="https://github.com/user-attachments/assets/7b2be5f6-46a3-450d-b015-f0523e7c9fd3" />


## Future Enhancements
- Implement user authentication and role-based access.
- Integrate REST APIs for better scalability.
- Add reporting and analytics features.
- Improve UI with modern frameworks like React or Angular.

## Author
**Ravi Patel**  
Java Full Stack Developer  

## License
This project is open-source and available under the MIT License.

