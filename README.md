# Book Library in Java REST APIs

## Description

A Spring Boot REST API for managing a book catalog.  
The project now focuses on **Book CRUD operations** with request validation, duplicate checks, and centralized error handling.

## What's New

- Refactored to a clean book-centric API (removed older person/library flows)
- Added DTO-based request/response model (`BookRequest`, `BookResponse`)
- Added bean validation for incoming payloads
- Added uniqueness checks for:
  - `isbn`
  - `title + author`
- Added global exception handling with structured error response
- Migrated build/tooling updates (Gradle + newer Spring Boot/Java config)

## Features

- Get all books
- Get a book by ID
- Create a new book
- Update an existing book
- Delete a book
- Input validation with clear validation error messages
- Conflict detection for duplicate books

## API Endpoints

Base path: `/api/books`

- `GET /api/books` → list all books
- `GET /api/books/{id}` → get one book
- `POST /api/books` → create book
- `PUT /api/books/{id}` → update book
- `DELETE /api/books/{id}` → delete book

### Sample Request Body (`POST` / `PUT`)

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publishedYear": 2008,
  "availableCopies": 5,
  "description": "A handbook of agile software craftsmanship.",
  "reviewPublished": true
}
```

### Request Fields

- `title` (string, required, max 150)
- `author` (string, required, max 100)
- `isbn` (string, required, 10-20 chars, digits/X/hyphen)
- `publishedYear` (number/year, required, must be in the past)
- `availableCopies` (number, required, minimum 0)
- `description` (string, optional, max 300)
- `reviewPublished` (boolean, optional, default `false`)

## Tech Stack

- Java (toolchain configured in Gradle)
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Validation (Jakarta Validation)
- H2 (in-memory DB for local development)
- Gradle

## Running Locally

```bash
git clone https://github.com/updeshxp/BookLibraryinJava.git
cd BookLibraryinJava
./gradlew bootRun
```

Application starts on `http://localhost:8080` by default.

Optional H2 console:

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:booklibrarydb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=TRUE`
- Username: `sa`
- Password: `sa`

## Error Handling

The API returns structured error responses via global exception handling for:

- `404 Not Found` (resource not found)
- `409 Conflict` (duplicate ISBN/title+author)
- `400 Bad Request` (validation failures)
- `500 Internal Server Error` (unexpected errors)

## Image

![This is an image of API for getting books list.](/image/booksList.png "This is an image of API for getting books list.")

## Links

- [Spring Initializer](https://start.spring.io/)
- [My Portfolio](https://updeshxp.github.io/)