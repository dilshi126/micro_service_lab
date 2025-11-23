package lk.ac.sjp.ict.result.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "Result Service");
        response.put("port", 8084);
        response.put("status", "Running");
        response.put("endpoints", new String[]{
            "POST /results - Add result",
            "GET /results/student/{id} - Get results for student"
        });
        return response;
    }
}
