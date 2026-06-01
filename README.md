# Ecommerce Microservices

A learning-focused microservices project built with Spring Boot. The goal of this project is to understand microservice architecture, service decomposition, inter-service communication, event-driven systems with Kafka, and containerization with Docker by building a complete e-commerce application.

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Apache Kafka (Planned)
* Docker (Planned)
* Maven

## Project Structure

```text
ecommerce-microservices/
│
├── user-service
├── product-service (Planned)
├── order-service (Planned)
├── payment-service (Planned)
└── notification-service (Planned)
```

## Current Progress

### Completed

* User Service

  * Create User
  * Get User by ID
  * Get All Users
  * Update User
  * Delete User

### Planned

* Product Service
* Order Service
* Payment Service
* Notification Service
* Kafka Integration
* Docker Compose Setup

## User Service APIs

### Create User

```http
POST /user
```

Request Body:

```json
{
  "name": "yaswanth",
  "email": "yaswanth24k@gmail.com"
}
```

### Get User By ID

```http
GET /user/{id}
```

### Get All Users

```http
GET /user
```

### Update User

```http
PUT /user/{id}
```

### Delete User

```http
DELETE /user/{id}
```

## Learning Objectives

* Understand microservice architecture
* Learn Spring Boot service development
* Implement service-to-service communication
* Explore event-driven architecture using Kafka
* Containerize services using Docker
* Build a complete e-commerce system using independent services

## Project Status

🚧 Under Development

This project is being built incrementally as part of a hands-on microservices learning journey.
