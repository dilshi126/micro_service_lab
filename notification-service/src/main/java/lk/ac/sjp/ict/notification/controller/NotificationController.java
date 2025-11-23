package lk.ac.sjp.ict.notification.controller;

import lk.ac.sjp.ict.notification.dto.EnrollmentNotificationRequest;
import lk.ac.sjp.ict.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/enrollment")
    public String sendEnrollmentNotification(@RequestBody EnrollmentNotificationRequest request) {
        return notificationService.sendEnrollmentNotification(request.getStudentId(), request.getCourseId());
    }
}
