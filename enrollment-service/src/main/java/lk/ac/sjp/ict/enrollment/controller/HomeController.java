package lk.ac.sjp.ict.enrollment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "Enrollment Service");
        response.put("port", 8083);
        response.put("status", "Running");
        response.put("endpoints", new String[]{
            "POST /enroll - Enroll student in course",
            "GET /enrollments/student/{id} - Get enrollments for student"
        });
        return response;
    }
}
