# Property Management CRUD System

## Project Summary

The Property Management CRUD System is a web application designed to facilitate the management of real estate properties. Users can create, read, update, and delete property listings through a simple and intuitive interface. This application demonstrates the use of Spring Boot for the backend REST API and a frontend built with HTML and JavaScript.

## System Architecture

The system is structured into three main components:

1. **Frontend**: 
   - Built with HTML, CSS, and JavaScript, the frontend allows users to interact with the system. It provides forms for creating and updating properties, as well as a list view to display existing properties.

2. **Backend**:
   - Developed with Spring Boot, the backend exposes RESTful endpoints for each CRUD operation. It handles data validation, persistence, and business logic.

3. **Database**:
   - A MySQL database is used to store property information, with JPA/Hibernate mapping the property objects to the database tables.

### Architecture

The application is deployed across two EC2 instances on AWS:

- **EC2 Instance 1 (Application Server)**: 
  - Hosts the Spring Boot application, which provides RESTful APIs for managing properties.

- **EC2 Instance 2 (Database Server)**: 
  - Hosts the MySQL database, which stores property listings and related information.

### Technology Stack
- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Spring Boot, JPA/Hibernate
- **Database**: MySQL
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
   - Responsible for handling business logic related to property management, including CRUD operations.

3. **PropertyController**
   - Exposes RESTful endpoints for the frontend to interact with the property data.

4. **PropertyRepository**
   - Interfaces with the database to perform CRUD operations on property listings.

### Class Diagram
![image](https://github.com/user-attachments/assets/cdbfde22-2b02-43e4-b46f-2c0a81324be6)

## Database Schema

### Properties Table
- **Table Name**: properties
- **Columns**:
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `address` (VARCHAR)
  - `price` (DECIMAL)
  - `size` (INT)
  - `description` (VARCHAR)

## Deployment Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/juaneortiz1/lab05-Arep.git
   ```

2. **Navigate to the Project Directory**
   ```bash
   cd lab05-Arep/
   ```

3. **Install Dependencies**
   - Ensure you have Java and Maven installed.
   - Build the project with Maven:
   ```bash
   mvn clean install
   ```

4. **Configure the Database**
   - Update `src/main/resources/application.properties` with your MySQL database credentials and connection details.

5. **Run the Application**
   ```bash
   java -jar target/accessing-data-jpa-initial-0.0.1-SNAPSHOT.jar
   ```

6. **Access the Application**
   - Open your web browser and navigate to:
   ```
   http://ec2-52-91-87-101.compute-1.amazonaws.com:8080
   ```

## Javadoc

The generated Java documentation can be found in the `docs` directory.

## Testing

Unit and integration tests are included in the project. To run the tests, execute the following Maven command:

```bash
mvn test
```
![image](https://github.com/user-attachments/assets/de7a3840-add4-49ce-ba99-b340f5065869)


The results of the tests will be displayed in the terminal.

## Demonstration video

https://github.com/user-attachments/assets/fcdfe09b-255a-4bf5-8708-1b22a2a0d80c


## Deployment Video


https://github.com/user-attachments/assets/c31bb496-94ac-4eeb-817f-b527ae2bfdf1


## License

This project is licensed under the MIT License.

## Contact

For any questions or further information, feel free to reach out:

Juan Esteban Ortiz
Email: juaneortiz1
