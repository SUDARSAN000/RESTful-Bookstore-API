#  RESTful Bookstore API

A Spring Boot–based RESTful backend for managing a bookstore with authors and books.

## Features

- CRUD APIs for `Book` and `Author`
- DTO pattern and layered architecture
- Global exception handling
- Input validation using `jakarta.validation`
- Spring Security with Basic Auth
- API docs using Swagger (OpenAPI 3)
- MySQL integration
- Lombok-powered clean code

##  Tech Stack

- Java 17
- Spring Boot 3.5.3
- Spring Data JPA
- MySQL
- Spring Security
- Swagger UI
- Postman
- Lombok

## Authentication

Use the following credentials for Swagger/Postman:

Username: admin
Password: admin@123

## API Endpoints

### Books

POST /api/books → Create a new book

GET /api/books → Get all books

GET /api/books/{id} → Get book by ID

PUT /api/books/{id} → Update a book

DELETE /api/books/{id} → Delete a book

### Authors


POST /api/author → Create a new author

GET /api/author → Get all authors

GET /api/author/{id} → Get author by ID

DELETE /api/author/{id} → Delete an author


## Swagger UI

Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
