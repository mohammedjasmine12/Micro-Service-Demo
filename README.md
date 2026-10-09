# Micro-Service-Demo

A Spring Boot Microservices Project

## Services
- **course-service** - Port 8081 - Manages Courses
- **student-service** - Port 8082 - Manages Students (calls course-service via OpenFeign)

## Tech Stack
Java, Spring Boot, Spring Cloud OpenFeign, MySQL, Maven

## How to Run
1. Run course-service on 8081
2. Run student-service on 8082
3. Student API will fetch course details automatically

Created by Mohammed Jasmine
