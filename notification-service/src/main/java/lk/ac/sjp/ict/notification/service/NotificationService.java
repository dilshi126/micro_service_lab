package lk.ac.sjp.ict.notification.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public String sendEnrollmentNotification(Long studentId, Long courseId) {
        String message = "Student " + studentId + " enrolled into Course " + courseId;
        System.out.println(message);
        return message;
    }
}
