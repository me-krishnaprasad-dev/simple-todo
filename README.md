# 📝 Simple ToDo Application

A basic ToDo list application built with **Java**, **Spring Boot**, and **PostgreSQL**. 
It provides a RESTful API to manage tasks with full CRUD functionality.

`
 
## 🛠️ Tech Stack  

- Java 25 
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/me-krishnaprasad-dev/simple-todoDTO.git
cd simple-todoDTO
```

### 2. Configure Environment Variables

Set the following environment variables in your system or in a `.env` file:

```env
DB_URL=jdbc:postgresql://localhost:5432/tododb
DB_USERNAME=yourusername
DB_PASSWORD=yourpassword
```

Then update `application.properties` to use them:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

## 📡 REST API Endpoints

| Method | Endpoint          | Description         |
| :----- | :---------------- | :------------------ |
| `GET`  | `/api/todos`      | Get all todos       |
| `GET`  | `/api/todos/{id}` | Get todoDTO by ID      |
| `POST` | `/api/todos`      | Create a new todoDTO   |
| `PUT`  | `/api/todos/{id}` | Update a todoDTO       |
| `DELETE` | `/api/todos/{id}` | Delete a todoDTO       |

## 📦 API Example (JSON)

**`POST /api/todos`**

```json
{
  "title": "Finish Spring Boot Project",
  "description": "Complete by Friday",
  "completed": false
}
```

## 🐳 PostgreSQL via Docker (Optional)

Run PostgreSQL locally with Docker:

```bash
docker run --name pg-todoDTO \
  -e POSTGRES_DB=tododb \
  -e POSTGRES_USER=yourusername \
  -e POSTGRES_PASSWORD=yourpassword \
  -p 5432:5432 \
  -d postgres
```  

## 👨‍💻 Author

Krishna Prasad A
me.krishnaprasad.dev@gmail.com
