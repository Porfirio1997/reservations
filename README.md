# Reservations API

API REST para gerenciamento de *reservas, **clientes* e *locais, com autenticação **JWT stateless* utilizando *Spring Boot 3* e *Spring Security 6*.

---

## 🧱 Stack

* Java 21
* Spring Boot 3.x
* Spring Security 6 (JWT)
* Spring Data JPA
* PostgreSQL
* Flyway
* Gradle
* Docker / Docker Compose
* Swagger / OpenAPI

---

## 🔐 Autenticação

A aplicação utiliza *JWT stateless*.

* Autenticação ocorre via *Filter (JwtAuthenticationFilter)*
* Não há roles de negócio
* É utilizada uma *authority técnica* (AUTHENTICATED) apenas para permitir acesso a rotas protegidas

### Fluxo

1. Login via /auth/login
2. Token JWT é gerado
3. Token deve ser enviado no header:

http
Authorization: Bearer <token>


4. O filtro valida o token e popula o SecurityContext

---

## 🔑 Endpoints públicos

text
/auth/**
/teste/**
/v3/api-docs/**
/swagger-ui/**


Todos os demais endpoints exigem autenticação.

---

## 📦 Principais módulos

text
config/        -> Configurações (Security, Swagger)
controller/    -> Controllers REST
dto/           -> DTOs de entrada e saída
exception/     -> Exceções de negócio e handler global
filter/        -> Filtro JWT
mapper/        -> Mapeadores DTO ↔ Entity
model/         -> Entidades JPA e Repositórios
service/       -> Regras de negócio
utils/         -> Utilitários (JWT)


---

## 🗄️ Banco de Dados

* PostgreSQL
* Versionamento de schema com *Flyway*
* Script inicial:

text
src/main/resources/db/migration/V1__init_schema.sql


---

## ▶️ Executando o projeto

### Com Docker

bash
docker-compose up --build


### Localmente

1. Suba o banco PostgreSQL
2. Ajuste as configurações em application.yml
3. Execute:

bash
./gradlew bootRun


---

## 📄 Swagger

Após subir a aplicação:

text
http://localhost:8080/swagger-ui/index.html


---

## ⚠️ Observações importantes

* A aplicação é *100% stateless*
* Não utiliza sessão HTTP
* Controllers não fazem autenticação
* Toda autenticação ocorre no filtro

---

## 🧪 Testes

bash
./gradlew test


---

## 📌 Padrões adotados

* Clean Architecture (camadas bem definidas)
* SRP (Single Responsibility Principle)
* Exceções de domínio
* DTOs para isolamento do modelo

---

## 🚀 Possíveis evoluções

* Introduzir roles ou scopes
* Refresh Token
* Testes de integração com Testcontainers
* Observabilidade (Micrometer + Prometheus)

---

## 👤 Autor

Projeto de estudo / demonstração de arquitetura com Spring Boot 3 e JWT.