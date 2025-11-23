# How to Run the Microservices

## Prerequisites
1. Java 17 or higher installed
2. Maven installed
3. PostgreSQL installed and running
4. pgAdmin (optional, for database management)

## Step 1: Setup PostgreSQL Databases

### Option A: Using pgAdmin
1. Open pgAdmin
2. Connect to your PostgreSQL server
3. Right-click on "Databases" → "Create" → "Database"
4. Create these 4 databases:
   - `studentdb`
   - `coursedb`
   - `enrollmentdb`
   - `resultdb`

### Option B: Using SQL Script
1. Open pgAdmin Query Tool or psql
2. Run the `setup-databases.sql` script

### Option C: Using Command Line
```bash
psql -U postgres -c "CREATE DATABASE studentdb;"
psql -U postgres -c "CREATE DATABASE coursedb;"
psql -U postgres -c "CREATE DATABASE enrollmentdb;"
psql -U postgres -c "CREATE DATABASE resultdb;"
```

## Step 2: Update Database Credentials (if needed)
If your PostgreSQL username/password is different from `postgres/postgres`, update these files:
- `student-service/src/main/resources/application.properties`
- `course-service/src/main/resources/application.properties`
- `enrollment-service/src/main/resources/application.properties`
- `result-service/src/main/resources/application.properties`

## Step 3: Run Each Service

Open 5 separate terminal windows and run each service:

### Terminal 1 - Student Service
```bash
cd student-service
mvn spring-boot:run
```
Service will start on: http://localhost:8081

### Terminal 2 - Course Service
```bash
cd course-service
mvn spring-boot:run
```
Service will start on: http://localhost:8082

### Terminal 3 - Enrollment Service
```bash
cd enrollment-service
mvn spring-boot:run
```
Service will start on: http://localhost:8083

### Terminal 4 - Result Service
```bash
cd result-service
mvn spring-boot:run
```
Service will start on: http://localhost:8084

### Terminal 5 - Notification Service
```bash
cd notification-service
mvn spring-boot:run
```
Service will start on: http://localhost:8085

## Step 4: Test the APIs

### 1. Create a Student
```bash
curl -X POST http://localhost:8081/students \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com"}'
```

### 2. Create a Course
```bash
curl -X POST http://localhost:8082/courses \
  -H "Content-Type: application/json" \
  -d '{"name":"Microservices","code":"ITS4243"}'
```

### 3. Enroll Student in Course
```bash
curl -X POST http://localhost:8083/enroll \
  -H "Content-Type: application/json" \
  -d '{"studentId":1,"courseId":1}'
```
This will trigger the Notification Service and print: "Student 1 enrolled into Course 1"

### 4. Add Result
```bash
curl -X POST http://localhost:8084/results \
  -H "Content-Type: application/json" \
  -d '{"studentId":1,"courseId":1,"grade":"A"}'
```

### 5. Get All Students
```bash
curl http://localhost:8081/students
```

### 6. Get Student Enrollments
```bash
curl http://localhost:8083/enrollments/student/1
```

### 7. Get Student Results
```bash
curl http://localhost:8084/results/student/1
```

## Using Postman
Import these endpoints into Postman for easier testing:
- Student Service: http://localhost:8081
- Course Service: http://localhost:8082
- Enrollment Service: http://localhost:8083
- Result Service: http://localhost:8084
- Notification Service: http://localhost:8085

## Verify in pgAdmin
1. Open pgAdmin
2. Connect to each database (studentdb, coursedb, enrollmentdb, resultdb)
3. Browse tables to see the data created by the services
4. Each service creates its own tables automatically

## Troubleshooting
- If port is already in use, change the port in `application.properties`
- Make sure PostgreSQL is running on port 5432
- Check database credentials match your PostgreSQL setup
- Ensure all databases are created before starting services
