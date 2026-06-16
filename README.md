# Library-Management-REST-API-

A fully functional **Spring Boot REST API** for managing a library system.
Built with Java, Spring Boot, Spring Data JPA, and MySQL.

## Features

- 📖 **Book Management** — Add, view, update, delete books
- ✍️ **Author Management** — Manage authors and their books
- 🏷️ **Category Management** — Organize books by categories (Many-to-Many)
- 👤 **User Management** — Users with linked profiles (One-to-One)
- 🔄 **Borrow & Return System** — Track who borrowed which book
- ⚠️ **Global Exception Handling** — Clean error responses (404, 409, 400)

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Spring Boot | Framework |
| Spring Data JPA | ORM / Database layer |
| Hibernate | JPA Implementation |
| MySQL | Database |
| Maven | Build tool |

---

## 🗂️ Project Structure
## 📡 API Endpoints

### 📖 Books

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/books` | Add a new book |
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get book by ID |
| PUT | `/books/{id}` | Update book details |
| DELETE | `/books/{id}` | Delete a book |
| PUT | `/books/{bookId}/borrow/{userId}` | Borrow a book |
| PUT | `/books/{bookId}/return/{userId}` | Return a borrowed book |

### ✍️ Authors

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/authors` | Add a new author |
| GET | `/authors` | Get all authors |
| GET | `/authors/{id}` | Get author by ID |
| PUT | `/authors/{id}` | Update author details |
| DELETE | `/authors/{id}` | Delete an author |

### 🏷️ Categories

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/categories` | Add a new category |
| GET | `/categories` | Get all categories |
| GET | `/categories/{id}` | Get category by ID |
| PUT | `/categories/{id}` | Update category |
| DELETE | `/categories/{id}` | Delete a category |

### 👤 Users

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/users` | Create a new user |
| GET | `/users` | Get all users |
| GET | `/users/{id}` | Get user by ID |
| PUT | `/users/{id}` | Update user details |
| DELETE | `/users/{id}` | Delete a user |

---

## 🔗 Entity Relationships

---

## ⚙️ How to Run Locally

### 1. Clone the repository
```bash
git clone https://github.com/LikithKasamsetty/Library-Management-REST-API-.git
cd Library-Management-REST-API-
```

### 2. Configure the database
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the application
```bash
mvn spring-boot:run
```

### 4. Test the API
Open your browser or Postman and hit:
---

## 📌 Sample Request & Response

### Borrow a Book
**Request:**
**Response (Success):**
```json
{
  "id": 1,
  "title": "Clean Code",
  "isbn": "978-0132350884",
  "borrowed": true,
  "borrowedBy": {
    "id": 2,
    "name": "Likith"
  }
}
```
**Response (Already Borrowed - 409):**
```json
{
  "timestamp": "2025-06-16T10:30:00",
  "status": 409,
  "error": "Conflict",
  "message": "Book is already borrowed by someone!"
}
```

---

## 👨‍💻 Author

**Likith Kasamsetty**
- GitHub: [@LikithKasamsetty](https://github.com/LikithKasamsetty)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
