🛒 E-Commerce Microservices System (Spring Boot + Kafka + Docker)

A scalable event-driven microservices-based e-commerce backend system built using Spring Boot, Kafka, MySQL, and Docker.
The system demonstrates synchronous REST communication + asynchronous event-driven architecture.

🚀 Architecture Overview

The system consists of 5 microservices:

User Service → Manages users
Product Service → Manages products and inventory
Order Service → Handles order creation and validation
Payment Service → Processes payments (Kafka consumer)
Notification Service → Sends order notifications (Kafka consumer)
🔄 Communication Flow
User Service        Product Service
\               /
→ Order Service → Kafka Topic (order-topic)
↓
-------------------------
|                       |
Payment Service       Notification Service
⚙️ Tech Stack
Java 24
Spring Boot
Spring Data JPA
Spring Kafka
MySQL
Apache Kafka
Docker & Docker Compose
REST APIs
📦 Microservices
Service	Port	Description
User Service	8081	User management
Product Service	8181	Product & stock management
Order Service	8083	Order creation + event producer
Payment Service	8282	Kafka consumer → payment processing
Notification Service	8383	Kafka consumer → notifications
🧠 Key Features
Microservices architecture
REST + Kafka hybrid communication
Event-driven order processing
MySQL per service schema
Dockerized deployment
Automatic JSON serialization with Kafka
Global exception handling
🐳 Run with Docker
1. Clone the repository
   git clone https://github.com/<your-username>/ecommerce-microservices.git
   cd ecommerce-microservices
2. Start the system
   docker compose up --build
3. Services will be available at:
   User Service → http://localhost:8081
   Product Service → http://localhost:8181
   Order Service → http://localhost:8083
   Payment Service → http://localhost:8282
   Notification Service → http://localhost:8383
   Kafka → localhost:9092
   MySQL → localhost:3307
   🧾 Example Flow
1. Create Order
   POST /orders
2. Order Service Actions:
   Validates user (User Service)
   Validates product & stock (Product Service)
   Calculates price
   Saves order in DB
   Publishes event → order-topic
3. Kafka Consumers:
   Payment Service
   Consumes order event
   Creates payment record
   Stores in MySQL
   Notification Service
   Consumes order event
   Prints notification message
   📊 Example Output
   Notification Service
   ORDER PLACED SUCCESSFULLY
   Order ID: 14
   User ID: 2
   Total Amount: 199999.0
   🗄️ Database Design

Each service has its own schema:

userdb
productdb
orderdb
paymentdb
🧱 Docker Setup

Includes:

MySQL container
Kafka container
Zookeeper container
5 Spring Boot services
📌 Future Improvements
API Gateway (Spring Cloud Gateway)
Service Discovery (Eureka)
Circuit Breaker (Resilience4j)
Centralized Logging (ELK stack)
Distributed tracing (Zipkin)
JWT Authentication
👨‍💻 Author

Built by Sai Yaswanth
Backend Developer | Microservices | Kafka | Spring Boot

⭐ If you like this project

Feel free to:

⭐ Star the repo
🍴 Fork it
🧠 Improve it