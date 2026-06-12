# E-Commerce Microservices

A microservices-based E-Commerce backend application built using Spring Boot, MySQL, Kafka, and Docker.

This project was built to learn and implement core microservice concepts such as service decomposition, inter-service communication, event-driven architecture, and asynchronous messaging using Apache Kafka.

---

## Architecture

```text
                        +------------------+
                        |   User Service   |
                        +------------------+
                                 ^
                                 |
                                 |
+--------+             +------------------+             +------------------+
| Client | ----------> |   Order Service  | ----------> | Product Service  |
+--------+             +------------------+             +------------------+
                                |
                                |
                                | Publish Event
                                v
                         +--------------+
                         |    Kafka     |
                         +--------------+
                           /          \
                          /            \
                         v              v
                +----------------+  +----------------------+
                | Payment Service|  | Notification Service |
                +----------------+  +----------------------+
                         |                    |
                         v                    v
                   MySQL Database      Console Notification
```

---

## Services

### User Service

Responsible for user management.

Features:
- Create User
- Get User By ID
- Get All Users
- Update User
- Delete User

---

### Product Service

Responsible for product management.

Features:
- Create Product
- Get Product By ID
- Get All Products
- Update Product
- Delete Product

---

### Order Service

Responsible for order processing.

Features:
- Validate User using User Service
- Validate Product using Product Service
- Check Product Stock
- Calculate Total Price
- Save Order
- Publish OrderCreatedEvent to Kafka

---

### Payment Service

Consumes OrderCreatedEvent from Kafka.

Features:
- Receive Order Event
- Generate Payment Record
- Store Payment Information in MySQL

---

### Notification Service

Consumes OrderCreatedEvent from Kafka.

Features:
- Receive Order Event
- Generate Order Confirmation Notification

---

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Apache Kafka
- Docker
- Maven
- REST APIs

---

## Event Driven Flow

```text
Order Created
      |
      v
Order Service
      |
      v
Kafka Topic (order-topic)
      |
      +--------------------+
      |                    |
      v                    v
Payment Service     Notification Service
      |                    |
      v                    v
Save Payment      Send Notification
```

---

## Features Implemented

- Microservice Architecture
- Service-to-Service Communication using RestTemplate
- Event-Driven Architecture using Kafka
- Kafka Producer
- Kafka Consumers
- Global Exception Handling
- Custom Exceptions
- MySQL Persistence
- Independent Databases per Service

---

## Future Improvements

- Docker Compose
- API Gateway
- Service Discovery (Eureka)
- Centralized Configuration
- Distributed Tracing
- Authentication & Authorization (JWT)
- Email Notifications

---

## Learning Outcomes

Through this project I learned:

- Designing Microservices
- Synchronous Communication using REST APIs
- Asynchronous Communication using Apache Kafka
- Event Publishing and Consumption
- Database Separation Across Services
- Exception Handling in Distributed Systems
- Building Scalable Backend Architectures

---

## Author

Sai Yaswanth

GitHub: https://github.com/yaswanth24k