package lk.ac.sjp.ict.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "Notification Service");
        response.put("port", 8085);
        response.put("status", "Running");
        response.put("endpoints", new String[]{
            "POST /notify/enrollment - Send enrollment notification"
        });
        return response;
    }
}
