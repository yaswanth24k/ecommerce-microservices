# Ecommerce Microservices

A learning-focused microservices project built using Spring Boot.  
The goal of this project is to understand how distributed systems work by building an e-commerce backend using microservice architecture.

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- REST APIs (RestTemplate)
- Maven

---

## Services

### ✅ Completed

#### User Service
- Create User
- Get User by ID
- Get All Users
- Update User
- Delete User

#### Product Service
- Create Product
- Get Product by ID
- Get All Products
- Update Product
- Delete Product

#### Order Service
- Create Order
- Validate User via User Service
- Validate Product via Product Service
- Check Product Stock
- Save Order

---

## Microservices Communication

Order Service communicates with:

- User Service → to validate user existence
- Product Service → to validate product and stock

Communication type:
- Synchronous REST calls using RestTemplate

---

## Current Architecture

User Service (8080)
Product Service (8181)
Order Service (8081)

Order Service:
→ Calls User Service
→ Calls Product Service
→ Validates request
→ Stores Order in MySQL

---

## Learning Goals

- Microservice decomposition
- Inter-service communication
- REST-based service communication
- Service validation logic
- Independent service deployment

---

## Project Status

🚧 In Progress

Next steps:
- Kafka event-driven architecture
- Payment Service
- Notification Service
- Docker Compose setup
