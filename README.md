# Flight Management System - Spring Backend

## Features
- User authentication (login and signup) using JWT tokens.
- CRUD operations for flights and bookings.
- Role-based access control (ADMIN and USER roles).
- Secure password storage using BCrypt hashing.
- Integration with Spring Security for authentication and authorization.

  ## Technologies Used
- **Spring Boot**: For building the backend application.
- **Spring Security**: For securing the APIs.
- **JWT (JSON Web Tokens)**: For user authentication.
- **Spring Data JPA**: For interacting with the database.
- **MySQL**: As the relational database.
- **Maven**: For project management and dependency resolution.

## Setup Instructions
1. **Clone the repository**
2. **Database Configuration**
- Ensure MySQL is installed and running.
- Update `application.properties` with your database credentials.
3. **Endpoints**
- **Authentication**: 
  - `POST /auth/login`: Login with username and password.
  - `POST /auth/signup`: Register a new user.
- **Flights**: 
  - `GET /user/flights`: Get all flights.
  - `GET /user/flights/{id}`: Get a flight by ID.
  - `POST /admin/flight`: Create a new flight.
  - `DELETE /admin/flight/{id}`: Delete a flight by ID.
  - `PUT /admin/flight/{id}`: Update a flight by ID.
  - `GET /user/flights/search`: Search flights by origin and destination.
- **Bookings**: 
  - `POST /user/bookings?flightId={flightId}&userid={userid}`: Book a flight for a user.
  - `GET /admin/bookings`: Get all bookings.
  - `DELETE /user/bookings/{id}`: Cancel a booking by ID.
- **Users**: 
  - `GET /admin/users`: Get all users (ADMIN only).
  - `DELETE /admin/users/{id}`: Delete a user by ID (ADMIN only).
  - `GET /user/getuser?username={username}`: Get user details by username.

4. **Security**
- Access to endpoints is restricted based on user roles (ADMIN and USER).
- JWT tokens are used for authentication and authorization.
