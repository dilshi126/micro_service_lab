# ITS4243 - Micro Services and Cloud Computing Lab Assessment

## Student Course Portal - Microservices System

### System Overview
A microservices-based Student Course Portal with 5 independent services:
- Student Service (Port 8081)
- Course Service (Port 8082)
- Enrollment Service (Port 8083)
- Result Service (Port 8084)
- Notification Service (Port 8085)

### Technical Stack
- Spring Boot 3.2.0
- Java 17
- PostgreSQL (separate database for each service)
- Maven
- Each service runs independently
- Inter-service communication via REST API
- JSON DTOs for request/response
- Full CRUD operations

### Database Configuration
Each service has its own PostgreSQL database:
- Student Service → `studentsdb`
- Course Service → `coursedb`
- Enrollment Service → `enrollmentdb`
- Result Service → `resultdb`
- Notification Service → No database (stateless)

### Services

#### Student Service (8081)
- `GET /students` - Get all students
- `POST /students` - Create student
- `GET /students/{id}` - Get student by ID

#### Course Service (8082)
- `GET /courses` - Get all courses
- `POST /courses` - Create course
- `GET /courses/{id}` - Get course by ID

#### Enrollment Service (8083)
- `POST /enroll` - Enroll student in course (body: studentId, courseId)
- `GET /enrollments/student/{id}` - Get enrollments for student
- Validates IDs with Student + Course services
- Triggers Notification Service on success

#### Result Service (8084)
- `POST /results` - Add result (body: studentId, courseId, grade)
- `GET /results/student/{id}` - Get results for student

#### Notification Service (8085)
- `POST /notify/enrollment` - Send enrollment notification
- Prints: "Student {id} enrolled into Course {id}"


## Setup and Run

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+ with pgAdmin
- Postman (for API testing)

### Step 1: Setup Databases
Create 4 PostgreSQL databases using pgAdmin or run:
```sql
CREATE DATABASE studentsdb;
CREATE DATABASE coursedb;
CREATE DATABASE enrollmentdb;
CREATE DATABASE resultdb;
```

Or use the provided `setup-databases.sql` script.

### Step 2: Configure Database Credentials
Update `application.properties` in each service if your PostgreSQL credentials differ from:
- Username: `postgres`
- Password: `postgres`
- Host: `localhost:5432`

### Step 3: Run Services
Open 5 separate terminals and run:

```bash
# Terminal 1
cd student-service && mvn spring-boot:run

# Terminal 2
cd course-service && mvn spring-boot:run

# Terminal 3
cd enrollment-service && mvn spring-boot:run

# Terminal 4
cd result-service && mvn spring-boot:run

# Terminal 5
cd notification-service && mvn spring-boot:run
```

### Step 4: Test APIs
See `RUN_SERVICES.md` for detailed API testing examples with curl and Postman.

## Quick Test Flow
1. Create a student: `POST http://localhost:8081/students`
2. Create a course: `POST http://localhost:8082/courses`
3. Enroll student: `POST http://localhost:8083/enroll`
4. Add result: `POST http://localhost:8084/results`
5. View data in pgAdmin

## Project Structure
```
micro_service_lab/
├── student-service/          # Port 8081
├── course-service/           # Port 8082
├── enrollment-service/       # Port 8083
├── result-service/           # Port 8084
├── notification-service/     # Port 8085
├── setup-databases.sql       # Database setup script
├── RUN_SERVICES.md          # Detailed run guide
└── README.md                # This file
```
