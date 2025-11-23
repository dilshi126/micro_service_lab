package lk.ac.sjp.ict.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "Student Service");
        response.put("port", 8081);
        response.put("status", "Running");
        response.put("endpoints", new String[]{
            "GET /students - Get all students",
            "POST /students - Create student",
            "GET /students/{id} - Get student by ID"
        });
        return response;
    }
}
