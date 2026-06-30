# OrderFlow

OrderFlow is an event-driven order management platform built with a microservices architecture using Spring Boot, Apache Kafka, PostgreSQL, OpenFeign, and Docker.

The project aims to simulate a real-world e-commerce order lifecycle while applying modern software architecture principles such as:

- Domain-driven service separation
- Event-driven communication
- Synchronous and asynchronous integrations
- Scalability and resilience patterns
- Containerized environments

---

## Architecture Overview

The platform is composed of independent microservices:

```text
Customer Service
        │
        ▼
Order Service ─────► Kafka ─────► Payment Service
        │                              │
        │                              ▼
        └──────────────────────► Notification Service

Product Service ───────────────► Order Service
```

### Communication

#### Synchronous

- OpenFeign
- REST APIs

#### Asynchronous

- Apache Kafka
- Event publishing and consuming

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Apache Kafka
- OpenFeign
- Docker
- JWT Authentication
- JUnit
- Mockito

---

## Infrastructure

The project infrastructure is fully containerized using Docker Compose.

### PostgreSQL

Database used by the microservices.

| Property | Value |
|----------|--------|
| Host | localhost |
| Port | 5432 |
| Database | orderflow |
| User | postgres |
| Password | postgres |

### pgAdmin

Database management interface.

| Property | Value |
|----------|--------|
| URL | http://localhost:5050 |
| Email | admin@orderflow.com |
| Password | admin |

### Apache Kafka

Event streaming platform used for asynchronous communication.

| Property | Value |
|----------|--------|
| Bootstrap Server | localhost:9092 |

### Kafka UI

Web interface for Kafka management and monitoring.

| Property | Value |
|----------|--------|
| URL | http://localhost:8080 |

---

## Services

### Customer Service

Responsible for:

- Customer registration
- Customer management
- Customer queries

### Product Service

Responsible for:

- Product catalog management
- Inventory control

### Order Service

Responsible for:

- Order creation
- Order orchestration
- Order status tracking
- Event publication

### Payment Service

Responsible for:

- Payment processing
- Payment validation
- Payment status publishing

### Notification Service

Responsible for:

- Customer notifications
- Order status updates

---

## Event Flow

### Order Created

```json
{
  "orderId": 1,
  "customerId": 100,
  "amount": 250.00,
  "status": "CREATED"
}
```

### Payment Approved

```json
{
  "orderId": 1,
  "status": "APPROVED"
}
```

### Order Completed

```json
{
  "orderId": 1,
  "status": "COMPLETED"
}
```

---

## Project Structure

```text
orderflow/
├── customer-service
├── product-service
├── order-service
├── payment-service
├── notification-service
├── docker-compose.yml
├── docs
└── infrastructure
```

---

## Quick Start

Clone the repository:

```bash
git clone https://github.com/AniltonViganigoJr/orderflow.git
```

Navigate to the project directory:

```bash
cd orderflow
```

Start the infrastructure:

```bash
docker compose up -d
```

Verify running containers:

```bash
docker ps
```

Open Kafka UI:

```text
http://localhost:8080
```

Open pgAdmin:

```text
http://localhost:5050
```

---

## Running the Project

### Prerequisites

- Java 21
- Docker
- Docker Compose

### Start Infrastructure

```bash
docker compose up -d
```

### Stop Infrastructure

```bash
docker compose down
```

### Remove Containers and Volumes

```bash
docker compose down -v
```

---

## Roadmap

### Infrastructure

- [x] Docker Compose
- [x] PostgreSQL
- [x] Apache Kafka
- [x] Kafka UI
- [x] pgAdmin

### Core Services

- [ ] Customer Service
- [ ] Product Service
- [ ] Order Service
- [ ] Payment Service
- [ ] Notification Service

### Communication

- [ ] OpenFeign Integration
- [ ] Kafka Producers
- [ ] Kafka Consumers

### Security

- [ ] JWT Authentication
- [ ] Role-Based Authorization

### Observability

- [ ] Spring Boot Actuator
- [ ] Prometheus
- [ ] Grafana
- [ ] Distributed Tracing

### Quality

- [ ] Unit Tests
- [ ] Integration Tests
- [ ] Testcontainers
- [ ] CI/CD Pipeline

---

## Future Improvements

- API Gateway

---

## Learning Goals

This project is intended to practice and demonstrate:

- Microservices Architecture
- Event-Driven Design
- Distributed Systems Concepts
- Service-to-Service Communication
- Asynchronous Processing
- Containerization
- Security and Authentication
- Observability and Monitoring

---

## Author

**Anilton Vigânigo Jr.**

Backend Developer focused on Java, Spring Boot, Distributed Systems, and Cloud-Native Applications.

GitHub: https://github.com/AniltonViganigoJr