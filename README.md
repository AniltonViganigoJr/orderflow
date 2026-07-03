# OrderFlow

O **OrderFlow** é uma plataforma de gerenciamento de pedidos orientada a eventos, desenvolvida com uma arquitetura de microsserviços utilizando **Spring Boot**, **Apache Kafka**, **PostgreSQL**, **OpenFeign** e **Docker**.

O objetivo do projeto é simular o ciclo de vida de pedidos de um e-commerce real, aplicando conceitos modernos de arquitetura de software, como:

- Separação de responsabilidades por domínio
- Comunicação orientada a eventos (Event-Driven Architecture)
- Integrações síncronas e assíncronas
- Escalabilidade e resiliência
- Ambientes conteinerizados com Docker

---

# Visão Geral da Arquitetura

A plataforma é composta pelos seguintes microsserviços:

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

## Comunicação entre os serviços

### Comunicação síncrona

- OpenFeign
- APIs REST

### Comunicação assíncrona

- Apache Kafka
- Publicação e consumo de eventos

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Apache Kafka
- OpenFeign
- Docker
- JWT Authentication
- JUnit
- Mockito

---

# Infraestrutura

Toda a infraestrutura da aplicação é executada utilizando **Docker Compose**.

## PostgreSQL

Banco de dados utilizado pelos microsserviços.

| Propriedade | Valor |
|-------------|-------|
| Host | localhost |
| Porta | 5432 |
| Banco | orderflow |
| Usuário | postgres |
| Senha | postgres |

---

## pgAdmin

Interface gráfica para gerenciamento do banco de dados.

| Propriedade | Valor |
|-------------|-------|
| URL | http://localhost:5050 |
| E-mail | admin@orderflow.com |
| Senha | admin |

---

## Apache Kafka

Plataforma de mensageria utilizada para comunicação assíncrona entre os microsserviços.

| Propriedade | Valor |
|-------------|-------|
| Bootstrap Server | localhost:9092 |

---

## Kafka UI

Interface web para monitoramento e gerenciamento do Kafka.

| Propriedade | Valor |
|-------------|-------|
| URL | http://localhost:8080 |

---

# Microsserviços

## Customer Service

Responsável por:

- Cadastro de clientes
- Gerenciamento de clientes
- Consulta de clientes

---

## Product Service

Responsável por:

- Cadastro de produtos
- Gerenciamento do catálogo
- Controle de estoque

---

## Order Service

Responsável por:

- Criação de pedidos
- Orquestração do fluxo dos pedidos
- Acompanhamento do status
- Publicação de eventos

---

## Payment Service

Responsável por:

- Processamento de pagamentos
- Validação do pagamento
- Publicação do status do pagamento

---

## Notification Service

Responsável por:

- Envio de notificações aos clientes
- Atualizações sobre o status dos pedidos

---

# Fluxo de Eventos

## Pedido Criado

```json
{
  "orderId": 1,
  "customerId": 100,
  "amount": 250.00,
  "status": "CREATED"
}
```

---

## Pagamento Aprovado

```json
{
  "orderId": 1,
  "status": "APPROVED"
}
```

---

## Pedido Concluído

```json
{
  "orderId": 1,
  "status": "COMPLETED"
}
```

---

# Estrutura do Projeto

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

# Como Executar o Projeto

## Clone o repositório

```bash
git clone https://github.com/AniltonViganigoJr/orderflow.git
```

Entre na pasta do projeto:

```bash
cd orderflow
```

---

## Suba toda a infraestrutura

```bash
docker compose up -d
```

Verifique os containers em execução:

```bash
docker ps
```

---

## Acesse os serviços

### Kafka UI

```
http://localhost:8080
```

### pgAdmin

```
http://localhost:5050
```

---

# Executando a Infraestrutura

## Pré-requisitos

- Java 21
- Docker
- Docker Compose

---

## Iniciar

```bash
docker compose up -d
```

---

## Parar

```bash
docker compose down
```

---

## Remover containers e volumes

```bash
docker compose down -v
```

---

# Roadmap

## Infraestrutura

- [ ] Docker Compose
- [ ] PostgreSQL
- [ ] Apache Kafka
- [ ] Kafka UI
- [ ] pgAdmin

---

## Microsserviços

- [ ] Customer Service
- [ ] Product Service
- [ ] Order Service
- [ ] Payment Service
- [ ] Notification Service

---

## Comunicação

- [ ] Integração com OpenFeign
- [ ] Producers Kafka
- [ ] Consumers Kafka

---

## Segurança

- [ ] Autenticação JWT

---

## Observabilidade

- [ ] Spring Boot Actuator
- [ ] Grafana

---

## Qualidade

- [ ] Testes Unitários
- [ ] Testes de Integração
- [ ] Testcontainers
- [ ] Pipeline CI/CD

---

# Melhorias Futuras

- API Gateway
- Kubernetes
- Deploy em Cloud (AWS/Azure/GCP)

---

# Objetivos de Aprendizagem

Este projeto foi desenvolvido para praticar e demonstrar conhecimentos em:

- Arquitetura de Microsserviços
- Event-Driven Architecture
- Sistemas Distribuídos
- Comunicação entre Microsserviços
- Processamento Assíncrono
- Apache Kafka
- Spring Boot
- OpenFeign
- Containerização com Docker
- Segurança com JWT
- Observabilidade e Monitoramento
- Boas práticas de desenvolvimento Backend

---

# Autor

**Anilton Vigânigo Jr.**

Desenvolvedor Backend com foco em **Java**, **Spring Boot**, **Microsserviços**, **Sistemas Distribuídos** e **Cloud Native**.

GitHub: https://github.com/AniltonViganigoJr