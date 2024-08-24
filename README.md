# Rest API for Online Movie Tickets Booking Application

A Spring Boot REST API web service for an online movie tickets booking application, developed using Core Java and the Spring Framework. The application utilizes a Oracle database for data storage and CRUD operations. The team consists of 2 members. This service enables customers to browse and book movie ticket. The API includes endpoints for movie and ticket management, user authentication, and more. The project is open-source and hosted on GitHub.

    
## Tech Stack and Tools
- Core Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Spring Validation
- Hibernate
- Oracle
- Lombok
- Postman

## Modules
- Login & Logout Module
- Admin Module
- User Module
- Movie Module
- Showtime Module
- Ticket Module
- Hall Module
- Seat Module

## Features:
### Admin Features
 - Admin can do all the operations like:
 - Add movie/showtime/seat/hall
 - Delete movie/showtime/seat/hall
 - View all movie/showtime/seat/hall
 
### User Features
 - Customer can do all the operations like:
 - Register himself
 - Login himself
 - Search for movie
 - View movie/showtime/seat details
 - Make a booking for a ticket
  
## Installation & Run
- To run this API server, you should update the database configuration inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database configuration.

server.port=8080
spring.datasource.url=jdbc:oracle:thin:@localhost:1522:xe
spring.datasource.username=your_username_here
spring.datasource.password=your_password_here
