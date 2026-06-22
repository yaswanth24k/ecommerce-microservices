# 🛒 E-Commerce Microservices System (Spring Boot + Kafka + Docker)

A distributed microservices-based backend system built using Spring Boot, Kafka, MySQL, and Docker Compose.  
This project demonstrates event-driven architecture in a simplified e-commerce workflow.

---

## 🚀 Architecture Overview

<img width="1536" height="1024" alt="ChatGPT Image Jun 22, 2026, 10_03_25 PM" src="https://github.com/user-attachments/assets/9f81bf66-617c-4c08-903b-90e78c921f93" />

## 🧱 Microservices

### 👤 User Service
- Manages user data
- CRUD operations (create, read, update, delete)

### 📦 Product Service
- Manages product catalog
- Stores price and stock details

### 🧾 Order Service
- Validates user via User Service (REST)
- Validates product via Product Service (REST)
- Calculates total price (quantity × product price)
- Saves order in MySQL
- Publishes order event to Kafka (`order-topic`)

### 💳 Payment Service
- Kafka Consumer
- Listens to order events
- Creates payment record automatically
- Stores payment in MySQL

### 🔔 Notification Service
- Kafka Consumer
- Listens to order events
- Prints order confirmation message

---

## ⚙️ Tech Stack

- Java 24
- Spring Boot
- Spring Data JPA
- Spring Web
- Apache Kafka
- MySQL 8
- Docker & Docker Compose

---

## 🔄 System Flow

1. Client sends order request
2. Order Service validates user and product
3. Order Service calculates total price
4. Order saved in database
5. Kafka event published (`order-topic`)
6. Payment Service consumes event → stores payment
7. Notification Service consumes event → prints confirmation

---
## 📦 Sample API Request

POST /orders

{
  "userid": 1,
  "productid": 1,
  "quantity": 2
}

---

## 🐳 Run Project with Docker

Step 1: Build JAR files
mvn clean package

Step 2: Start all services
docker compose up --build

Step 3: Stop system
docker compose down

---

## 🗄️ Database

- MySQL runs inside Docker
- Each service has its own table schema
- Hibernate auto-generates tables (ddl-auto=update)

---

## ✨ Key Features

- Microservices architecture
- Event-driven communication using Kafka
- REST-based service communication
- Dockerized full system
- Real-world backend workflow simulation

---

## 🚀 Future Improvements

- API Gateway (Spring Cloud Gateway)
- Eureka Service Discovery
- JWT Authentication
- Centralized Config Server
- Retry + Dead Letter Queue for Kafka
- Kubernetes deployment

---

## 👨‍💻 Author

Yaswanth  
GitHub: https://github.com/yaswanth24k

---

## 🧠 Learning Outcome

This project demonstrates:

- Microservices design
- Event-driven architecture using Kafka
- Inter-service communication (REST + Messaging)
- Docker-based deployment
