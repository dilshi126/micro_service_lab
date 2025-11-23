package lk.ac.sjp.ict.enrollment.controller;

import lk.ac.sjp.ict.enrollment.dto.EnrollmentRequest;
import lk.ac.sjp.ict.enrollment.model.Enrollment;
import lk.ac.sjp.ict.enrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody EnrollmentRequest request) {
        try {
            Enrollment enrollment = enrollmentService.enrollStudent(request.getStudentId(), request.getCourseId());
            return ResponseEntity.ok(enrollment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/enrollments/student/{id}")
    public List<Enrollment> getEnrollmentsByStudentId(@PathVariable Long id) {
        return enrollmentService.getEnrollmentsByStudentId(id);
    }
}
