# Inditex Price Service Application

This is a technical test application for Inditex made with Spring Boot, designed to manage and query prices in a database. It follows a hexagonal architecture integrated with Domain-Driven Design (DDD) principles.

## Author
- [Alberto Pereira](https://github.com/AlberDeveloper)
## Features

- **Domain-Driven Design**: Organized into distinct layers: Domain, Application, and Infrastructure.
- **RESTful API**: Exposes endpoints for querying prices.
- **Global Exception Handling**: Ensures a consistent error response format.
- **Spring Data JPA**: Facilitates database interactions.
- **Docker Support**: Includes a `Dockerfile` for containerization.
- **H2 Database**: Embedded database for quick testing and development.

## Prerequisites

- Java 17 or higher.
- Maven 3.6+.
- Docker and build kit(optional, for containerized deployment).

## How to Run
- Clone this repository:
   ```bash
   git clone https://github.com/AlberDeveloper/inditex.git
   cd inditex
   ```

### Using Maven
1. Build and run the project:
   ```bash
   ./mvnw spring-boot:run
2. The application will start on http://localhost:8080/.

### Using Docker
1. Generate .jar file:
   ```bash
   mvn clean compile install
2. Build the Docker image:
   ```bash
   docker build -t price-service .
   ```
   Or through Buildkit tool:
   ```bash
   docker buildx build -t price-service .
3. Run the Docker container:
   ```bash
   docker run -p 8080:8080 price-service
4. The application will start on http://localhost:8080/.

## API Endpoints
- **`GET /v1/api/prices/getPrice`**: Fetch price based on parameters (date, product ID and brand ID).

## Project Structure

```plaintext
src/main/java/com/inditex/service/price
├── application
│   └── service
│       ├── PriceService.java         # Service interface
│       └── impl
│           └── PriceServiceImpl.java # Service implementation
├── domain
│   ├── entity
│   │   └── Price.java                # Domain entity
│   ├── exception
│   │   ├── GlobalExceptionHandler.java # Global exception handler
│   │   └── PriceNotFoundException.java # Custom exception
│   └── repository
│       └── PriceRepository.java      # Repository interface
├── infrastructure
│   ├── controller
│   │   └── PriceController.java      # REST controller
│   └── dto
│       └── PriceResponseDto.java     # DTO for API responses
└── PriceApplication.java             # Main application class
```

## Configuration
- application.yml: Define database configurations and application properties.

## Development and Testing
- Use the H2 database for local testing. Access the database console at http://localhost:8080/h2-console.
- Unit tests can be run using:
   ```bash
   ./mvnw test