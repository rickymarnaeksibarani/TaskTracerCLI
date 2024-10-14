
# TaskTracker - Employee : https://roadmap.sh/projects/task-tracker

## Overview

The TaskTracker - Employee is a robust application built with Spring Boot, PostgreSQL designed to streamline the simple CRUD operations.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **PostgreSQL**: Relational database for storing data.
- **Java**: Programming language used for backend development.
- **Maven**: Build automation tool for Java projects.

## Features

- **Multi-Environment Configuration**: Support for multiple environments (QA and PROD) with customizable configurations.
- **Custom Exception Handling**: Implements a custom exception handling mechanism through `CustomRequestException` to manage application errors gracefully.
- **Status Employee**: CONTRACT, FULLTIME, PARTTIME.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 17 or higher
- Maven
- PostgreSQL

### Configuration

1. **Clone the Repository**:
   ```bash
   git clone *reposistory-link
   cd project

2. Go to into file application.yml and then :
- change url, port, and database name :
>spring.datasource.url=jdbc:postgresql://localhost:5432/db_employee-learning

- change username :
>spring.datasource.username=postgres

- change password :
>spring.datasource.password=0000

3. Go to terminal and run :
```bash
# Install dependency
$ mvn install

# run spring boot
$ mvn spring-boot:run
```

# Install dependency
$ --console-address :9001
```

## Reference Documentation
### The following links provide useful reference material for the technologies used in this project:
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#using.devtools)
* [PostgreSQL documentation](https://www.postgresql.org/docs/14/index.html)

## Rest API Documentation
POST: localhost:8080/api/employee
{
    "description" : "this is description",
    "status" : "CONTRACT"
}

PUT: localhost:8080/api/employee/1
{
   "description" : "this is description was update",
   "status" : "FULLTIME" 
}

GET: localhost:8080/api/employee
params: 
1. status: PARTTIME, FULLTIME, CONTRACT
2. page: 1
3. size: 10

result:
{
    "status": "OK",
    "message": "Success retrieved data",
    "result": {
        "data": [
            {
                "id": 1,
                "description": "this is description 1 ",
                "status": "PARTTIME",
                "createdAt": "2024-10-14T08:57:43.616596",
                "updatedAt": "2024-10-14T08:57:43.616596"
            }
        ],
        "currentPage": 1,
        "totalItems": 1,
        "lastPage": 1,
        "totalItemsPerPage": 1,
        "hasPrev": false,
        "hasNext": false
    }
}
