# Property Management CRUD System with https and multiple instances

## Project Summary

The Property Management CRUD System is a web application designed to manage real estate properties. Users can create, read, update, and delete property listings through an intuitive interface. The system is now split into two distinct components: the client hosted on an Ubuntu EC2 instance with Apache, and the backend REST API hosted on a separate EC2 instance running Spring Boot. The application is secured using HTTPS via Let's Encrypt.

## System Architecture

The system consists of the following components:

1. **Frontend (Client)**: 
   - Hosted on an Ubuntu EC2 instance with Apache. The frontend is built using HTML, CSS, and JavaScript. It provides the user interface for property management and handles the connection to the backend via HTTPS requests.

2. **Backend (API)**:
   - Hosted on a separate EC2 instance running Spring Boot. The backend provides the RESTful API for property management, user authentication, and registration. It includes a MySQL database for data persistence.

3. **Database**:
   - The MySQL database is hosted alongside the Spring Boot backend. It stores property information and user details, such as login credentials.

### Architecture Overview

The application is deployed across two EC2 instances on AWS:

- **EC2 Instance 1 (Client - Ubuntu with Apache)**:
  - Hosts the frontend of the application. All client-side assets like `index.html`, `login.html`, `register.html`, `styles.css`, and JavaScript files are served through Apache. Requests from the frontend are securely sent to the backend API using HTTPS.

- **EC2 Instance 2 (Backend - Spring Boot)**:
  - Hosts the backend REST API, which handles property management and user authentication. This instance communicates with a MySQL database to manage property data.

- **Let's Encrypt Certificate**: 
  - The system is secured using HTTPS with a Let's Encrypt certificate, ensuring that all communication between the frontend and backend is encrypted.

### Technology Stack

- **Frontend**: HTML, CSS, JavaScript, Apache (on Ubuntu)
- **Backend**: Spring Boot, JPA/Hibernate, MySQL
- **Database**: MySQL
- **Security**: HTTPS with Let's Encrypt, Spring Security
- **Build Tool**: Maven

## Class Design

### Main Classes

1. **Property**
   - Attributes:
     - `id`: Long (generated automatically)
     - `address`: String
     - `price`: Double
     - `size`: Integer
     - `description`: String

2. **PropertyService**
   - Contains business logic for property management, including CRUD operations.

3. **PropertyController**
   - Exposes RESTful endpoints for managing properties.

4. **PropertyRepository**
   - Interacts with the database to perform CRUD operations on property entities.

5. **User** 
   - Attributes:
     - `id`: Long
     - `username`: String
     - `password`: String (stored as a hashed value)
   
6. **SecurityConfig**
   - Manages Spring Security configurations, such as user authentication, session management, and access control.

### Class Diagram

![image](https://github.com/user-attachments/assets/cdbfde22-2b02-43e4-b46f-2c0a81324be6)

## Deployment Instructions

### Frontend (Client) Deployment:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/juaneortiz1/lab05-Arep.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd lab05-Arep/
   ```

3. **Upload Client Files to Apache**:
   Copy the frontend files (e.g., `index.html`, `login.html`, `register.html`, `styles.css`, etc.) to `/var/www/html/` on your Ubuntu server.

   ```bash
   sudo cp index.html login.html register.html styles.css /var/www/html/
   ```

4. **Set the Default Page to `login.html`**:
   Edit your Apache configuration to make `login.html` the default page:

   ```bash
   sudo nano /etc/httpd/conf/httpd.conf
   ```

   Add the following line under the `<IfModule dir_module>` section:

   ```bash
   DirectoryIndex login.html
   ```

5. **Restart Apache**:
   ```bash
   sudo systemctl restart httpd
   ```

6. **Install Let's Encrypt SSL Certificate**:
   Follow the Let's Encrypt instructions to install an SSL certificate:

   ```bash
   sudo certbot --apache -d yourdomain.com
   ```

### Backend (Spring Boot) Deployment:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/juaneortiz1/lab05-Arep.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd lab05-Arep/
   ```

3. **Configure the Database**:
   Update `src/main/resources/application.properties` with your MySQL credentials and connection details.

   ```properties
   spring.datasource.url=jdbc:mysql://your-mysql-host:3306/property_db
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   ```

4. **Install Dependencies and Build the Project**:
   ```bash
   mvn clean install
   ```

5. **Run the Application**:
   ```bash
   java -jar target/accessing-data-jpa-initial-0.0.1-SNAPSHOT.jar
   ```

6. **Access the Backend API**:
   The API will be available at:

   ```
   https://backlabseis6.duckdns.org/
   ```

## Database Schema

### Properties Table
- **Table Name**: `properties`
- **Columns**:
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `address` (VARCHAR)
  - `price` (DECIMAL)
  - `size` (INT)
  - `description` (VARCHAR)

### Users Table
- **Table Name**: `users`
- **Columns**:
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `username` (VARCHAR)
  - `password` (VARCHAR) (hashed)

## Security

The backend API is secured using Spring Security. All access to property management endpoints requires authentication. User passwords are securely hashed using BCrypt. Authentication is managed through the login page (`login.html`) served by the Apache server on the frontend.

## HTTPS

All client-server communication is secured with HTTPS via Let's Encrypt. Ensure that both the client and backend URLs use `https://` to avoid mixed-content issues.

https://github.com/user-attachments/assets/b0500420-d6ad-45aa-af36-6b3659e692db



## Testing

Unit and integration tests are included in the project. To run the tests, execute the following Maven command:

```bash
mvn test
```

## License

This project is licensed under the MIT License.

## Contact

For any questions or further information, feel free to reach out:

Juan Esteban Ortiz  
Email: juaneortiz1  
