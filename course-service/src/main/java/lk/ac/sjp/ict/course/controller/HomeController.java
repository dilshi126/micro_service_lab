package lk.ac.sjp.ict.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "Course Service");
        response.put("port", 8082);
        response.put("status", "Running");
        response.put("endpoints", new String[]{
            "GET /courses - Get all courses",
            "POST /courses - Create course",
            "GET /courses/{id} - Get course by ID"
        });
        return response;
    }
}
