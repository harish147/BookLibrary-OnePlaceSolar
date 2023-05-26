# Book Library Spring Boot Project

This project is a Spring Boot application built using the MVC (Model-View-Controller) architectural pattern. 
It provides a foundation for building web applications with Spring Boot and handling HTTP requests and responses.

## Prerequisites

Before running this project, make sure you have the following prerequisites installed:

- Java Development Kit (JDK) 11 
- Apache Maven
- Any Database 

<br>

### Database Configuration

- In the src/main/resources directory, locate the application.properties file.
- Modify the following properties in the application.properties file to match your database settings:
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
    spring.datasource.username=myusername
    spring.datasource.password=mypassword
    ```
    Replace mydatabase, myusername, and mypassword with the name of your database, your database username, and your database password, respectively.
    
- add dialect for your database 
  ```
    spring.jpa.database-platform=
  ```
- Save the application.properties file.

### Dependancy Configuration

- In pom.xml add dependancy for database connector
- for example:
  ```
      <dependency>
			<groupId>com.microsoft.sqlserver</groupId>
			<artifactId>mssql-jdbc</artifactId>
			<scope>runtime</scope>
		</dependency>
  ```
  
  
### Running the Application

- Open terminal in a project root directory
- Build and start the application using the following command

    ```
   mvn spring-boot:run
    ```
- Open http://localhost:8080/ in a browser
<br>


### Login as Admin
- Default Admin credentials are 
```
  username : admin
  password : admin
```

### Recomended Use
- Login as Admin
- Create some book using Admin Panel
- Logout from Admin Panel
- Register as a User
- Login as a User 
- Add books to Favorite Books
- Remove Books from the favorite Books
