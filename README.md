# InvenTree — Product Inventory Management System

A simple MVC-based web application built with **Spring Boot** and **Hibernate (Spring Data JPA)** for managing product inventory. Designed as a clean, beginner-friendly academic demo demonstrating complete CRUD operations.

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Spring Boot 3.3.7 | Backend framework |
| Spring MVC | MVC architecture |
| Hibernate / Spring Data JPA | ORM & database access |
| MySQL | Production database |
| H2 | In-memory database (testing) |
| Thymeleaf | Server-side HTML templating |
| Maven | Build & dependency management |
| Java 17 | Language version |

---

## Project Structure

```
InvenTree/
├── pom.xml
├── run.bat                                    # Run script
└── src/main/
    ├── java/com/inventree/
    │   ├── InvenTreeApplication.java          # Entry point
    │   ├── entity/Product.java                # JPA Entity
    │   ├── repository/ProductRepository.java  # Data layer
    │   ├── service/ProductService.java        # Business logic
    │   └── controller/ProductController.java  # MVC Controller
    └── resources/
        ├── application.properties             # DB & app config
        └── templates/
            ├── product-list.html              # List all products
            ├── add-product.html               # Add product form
            └── edit-product.html              # Edit product form
```

---

## Features

- **Add Product** — Form with name, price, quantity (with validation)
- **View Products** — Table listing all products
- **Update Product** — Edit existing product details
- **Delete Product** — Remove product with confirmation prompt

---

## MVC Architecture

```
[Browser] → Controller → Service → Repository → Database
                ↓
          Thymeleaf View
```

| Layer | Class | Annotation |
|---|---|---|
| Entity | `Product.java` | `@Entity` |
| Repository | `ProductRepository.java` | `@Repository` |
| Service | `ProductService.java` | `@Service` |
| Controller | `ProductController.java` | `@Controller` |

---

## API Endpoints

| Method | URL | Description |
|---|---|---|
| GET | `/products` | List all products |
| GET | `/add` | Show add product form |
| POST | `/add` | Save new product |
| GET | `/edit/{id}` | Show edit form for product |
| POST | `/edit/{id}` | Update product |
| GET | `/delete/{id}` | Delete product |

---

## Prerequisites

- Java 17+
- MySQL Server (running on `localhost:3306`)
- Maven (or NetBeans with bundled Maven)

---

## How to Run

### Option 1: Using the batch file
```
run.bat
```

### Option 2: Using Maven
```bash
mvn spring-boot:run
```

### Option 3: Using NetBeans
Open the project in NetBeans and run `InvenTreeApplication.java`.

Then visit: **http://localhost:8080/products**

---

## Database Configuration

### MySQL (default)
The app auto-creates the database `inventree_db` on MySQL. Update credentials in `application.properties` if needed:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventree_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
```

### H2 (for testing)
To switch to H2, comment out MySQL config and uncomment H2 config in `application.properties`. Access H2 console at `/h2-console`.

---

## Validation Rules

| Field | Validation |
|---|---|
| `name` | Cannot be blank |
| `price` | Must be a positive number |
| `quantity` | Must be a positive number |

---

## License

This project is for academic/demo purposes.
