🛒 E-Commerce Microservices System (Spring Boot + Kafka + Docker)

A distributed e-commerce backend system built using Spring Boot microservices architecture, demonstrating event-driven communication using Kafka, containerized using Docker & Docker Compose.

This project simulates a real-world scalable backend system where services operate independently and communicate asynchronously.

🚀 Architecture Overview

The system is composed of the following microservices:

User Service → Manages user data
Product Service → Manages product catalog and inventory
Order Service → Handles order placement and validation
Payment Service → Processes payments based on order events
Notification Service → Sends order notifications via Kafka events
🧩 System Design
🔄 Flow of the System
User places an order
Order Service:
Validates User (via REST call)
Validates Product (via REST call)
Calculates total price
Saves order in database
Publishes OrderCreatedEvent to Kafka
Kafka distributes event to:
💳 Payment Service → Creates payment record
📢 Notification Service → Sends order confirmation message
🛠️ Tech Stack
Backend: Spring Boot
Microservices Communication: REST + Kafka
Database: MySQL
Messaging Broker: Apache Kafka
Containerization: Docker, Docker Compose
ORM: Spring Data JPA / Hibernate
Build Tool: Maven
📦 Services & Ports
Service	Port
User Service	8081
Product Service	8082
Order Service	8083
Payment Service	8282
Notification Service	8383
Kafka	9092
MySQL	3307
⚙️ How to Run (Dockerized Setup)
1. Clone the repository
git clone https://github.com/yaswanth24k/ecommerce-microservices.git
cd ecommerce-microservices
2. Build and start all services
docker compose up --build
3. Stop all services
docker compose down
🧪 Example Order Request
POST /orders
{
  "userid": 1,
  "productid": 1,
  "quantity": 2,
  "price": 199999
}
📡 Event-Driven Architecture
Kafka Topic
order-topic
Event Payload Example
{
  "orderid": 14,
  "userid": 2,
  "productid": 1,
  "quantity": 2,
  "price": 399998
}
💳 Payment Service Behavior
Listens to order-topic
Creates payment record automatically
Stores:
orderId
userId
amount
status = SUCCESS
📢 Notification Service Behavior
Listens to order-topic
Prints real-time order confirmation:
========== NOTIFICATION SERVICE ==========
Order Placed Successfully!
Order ID: 14
User ID: 2
Total Amount: 399998
=========================================
🐳 Docker Setup

The system includes:

MySQL container (persistent volume)
Kafka + Zookeeper containers
5 Spring Boot microservices

All services are orchestrated using:

docker-compose.yml
📌 Key Learnings
Microservices architecture design
REST + Kafka hybrid communication
Event-driven system design
Docker container orchestration
Service decoupling & scalability patterns
📈 Future Improvements
API Gateway (Spring Cloud Gateway)
Service Discovery (Eureka)
Centralized logging (ELK stack)
Resilience (Resilience4j)
JWT Authentication
Monitoring (Prometheus + Grafana)
⭐ Author

Yaswanth
