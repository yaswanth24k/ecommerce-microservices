# 🛒 E-Commerce Microservices System (Spring Boot + Kafka + Docker)

A **distributed microservices-based e-commerce backend system** built for learning and demonstrating real-world backend architecture using **Spring Boot, Kafka, MySQL, and Docker Compose**.

This project simulates a simplified e-commerce platform where services communicate asynchronously using **event-driven architecture (Kafka)**.

---

# 🚀 System Overview

This system consists of 5 independent microservices:

### 👤 User Service
- Manages users
- CRUD operations for user data

### 📦 Product Service
- Manages products
- Tracks price and stock

### 🧾 Order Service
- Core service
- Validates user & product using REST calls
- Creates orders
- Publishes order events to Kafka

### 💳 Payment Service
- Consumes order events from Kafka
- Creates payment records automatically
- Simulates payment processing

### 🔔 Notification Service
- Consumes order events from Kafka
- Prints order confirmation notifications

---

# 🧱 Architecture Diagram

            ┌────────────────────┐
            │   User Service     │
            │  (Spring Boot)     │
            └─────────┬──────────┘
                      │
                      │ REST API
                      ▼
            ┌────────────────────┐
            │  Order Service     │
            │  (Spring Boot)     │
            └─────────┬──────────┘
                      │
                      │ Kafka Event (order-topic)
                      ▼
    ┌──────────────────────────────┐
    │            Kafka             │
    └──────────────┬───────────────┘
                   │
     ┌─────────────┴─────────────┐
     ▼                           ▼

┌──────────────────┐ ┌────────────────────┐
│ Payment Service │ │ Notification Service│
│ (Consumer) │ │ (Consumer) │
└──────────────────┘ └────────────────────┘

                      ▲
                      │ REST API
                      │
            ┌────────────────────┐
            │ Product Service    │
            │ (Spring Boot)      │
            └────────────────────┘

            ┌────────────────────┐
            │   MySQL Database   │
            └────────────────────┘

---

# ⚙️ Tech Stack

- Java 24
- Spring Boot
- Spring Data JPA
- Spring Web
- Apache Kafka
- MySQL 8
- Docker & Docker Compose
- REST Template (Service Communication)

---

# 📡 Communication Flow

### Order Placement Flow:

1. Client calls **Order Service**
2. Order Service:
   - Validates user via User Service (REST)
   - Validates product via Product Service (REST)
   - Calculates total price
   - Saves order in DB
3. Order Service publishes event → `order-topic` (Kafka)
4. Payment Service consumes event:
   - Creates payment record
5. Notification Service consumes event:
   - Prints confirmation message

---

# 📦 Sample Order Request

```json
POST /orders
{
  "userid": 1,
  "productid": 1,
  "quantity": 2
}
🐳 Running the Project (Docker Compose)
1. Build JAR files

Run in each service:

mvn clean package
2. Start everything

From project root:

docker compose up --build
3. Stop system
docker compose down
🗄️ Database
MySQL runs in Docker
Auto table creation enabled using Hibernate (ddl-auto=update)
Separate schema per service
🧠 Key Features
Microservices architecture
REST-based inter-service communication
Event-driven architecture using Kafka
Containerized deployment using Docker
Real-time order processing flow
Separation of concerns per service
📈 Future Improvements
API Gateway (Spring Cloud Gateway)
Service Discovery (Eureka)
Centralized Config Server
JWT Authentication
Distributed tracing (Zipkin / Sleuth)
Kubernetes deployment
Retry & Dead Letter Queue for Kafka
🧑‍💻 Author

Yaswanth

GitHub: https://github.com/yaswanth24k

⭐ Learning Outcome

This project demonstrates:

Real-world backend system design
Event-driven microservices communication
Containerized development workflow
Integration of Kafka with Spring Boot
Multi-service orchestration using Docker Compose

---
