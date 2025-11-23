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
- Spring Boot
- Each service runs independently
- Each service has its own database
- Inter-service communication via REST API
- JSON DTOs for request/response
- Full CRUD operations

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
