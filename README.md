# Ecommerce Microservices

A learning-focused microservices project built with Spring Boot. This project is being developed to understand microservice architecture, service-to-service communication, event-driven systems, and containerization by building a simplified e-commerce application.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* RestTemplate
* Apache Kafka (Planned)
* Docker (Planned)

## Architecture

```text
                ┌──────────────┐
                │ Order Service│
                └──────┬───────┘
                       │
             ┌─────────┴─────────┐
             │                   │
             ▼                   ▼
      User Service       Product Service
```

Currently, the Order Service communicates with the User Service and Product Service to validate orders before storing them.

## Services

### User Service

Features:

* Create User
* Get User by ID
* Get All Users
* Update User
* Delete User

### Product Service

Features:

* Create Product
* Get Product by ID
* Get All Products
* Update Product
* Delete Product

### Order Service

Features:

* Create Order
* Get Order by ID
* Get All Orders
* Update Order
* Delete Order
* Validate User Existence
* Validate Product Existence
* Validate Product Stock Availability
* Custom Exception Handling

## Project Structure

```text
ecommerce-microservices/
│
├── user-service/
├── product-service/
├── order-service/
├── payment-service/        (Planned)
├── notification-service/   (Planned)
└── README.md
```

## Current Workflow

When an order is created:

1. Order Service receives the request.
2. User Service is called to verify the user exists.
3. Product Service is called to verify the product exists.
4. Product stock is validated.
5. Order is saved to the database.
6. Appropriate exceptions are returned if validation fails.

## Exception Handling

Implemented using:

* UserNotFoundException
* ProductNotFoundException
* InsufficientStockException
* GlobalExceptionHandler

Returns meaningful HTTP responses instead of generic server errors.

## Current Progress

* [x] User Service
* [x] Product Service
* [x] Order Service
* [x] REST-based Service-to-Service Communication
* [x] Business Validation
* [x] Custom Exception Handling
* [x] Global Exception Handling

### Upcoming Features

* [ ] Kafka Integration
* [ ] Payment Service
* [ ] Notification Service
* [ ] Event-Driven Communication
* [ ] Docker Compose Setup
* [ ] API Gateway
* [ ] Service Discovery

## Learning Objectives

* Understand Microservice Architecture
* Build Independent Services
* Implement Service-to-Service Communication
* Learn Event-Driven Architecture with Kafka
* Containerize Applications using Docker
* Explore Distributed System Concepts

## Project Status

🚧 Under Development

Current milestone: Three independent microservices are implemented and communicating through REST APIs. The next phase is introducing Kafka for asynchronous communication between services.
