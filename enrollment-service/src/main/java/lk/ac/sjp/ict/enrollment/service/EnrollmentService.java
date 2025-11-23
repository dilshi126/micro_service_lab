package lk.ac.sjp.ict.enrollment.service;

import lk.ac.sjp.ict.enrollment.model.Enrollment;
import lk.ac.sjp.ict.enrollment.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${student.service.url}")
    private String studentServiceUrl;

    @Value("${course.service.url}")
    private String courseServiceUrl;

    @Value("${notification.service.url}")
    private String notificationServiceUrl;

    public Enrollment enrollStudent(Long studentId, Long courseId) {
        // Validate student exists
        String studentUrl = studentServiceUrl + "/students/" + studentId;
        try {
            restTemplate.getForObject(studentUrl, Object.class);
        } catch (Exception e) {
            throw new RuntimeException("Student not found");
        }

        // Validate course exists
        String courseUrl = courseServiceUrl + "/courses/" + courseId;
        try {
            restTemplate.getForObject(courseUrl, Object.class);
        } catch (Exception e) {
            throw new RuntimeException("Course not found");
        }

        // Create enrollment
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);
        enrollment = enrollmentRepository.save(enrollment);

        // Send notification
        String notificationUrl = notificationServiceUrl + "/notify/enrollment";
        Map<String, Long> notificationRequest = new HashMap<>();
        notificationRequest.put("studentId", studentId);
        notificationRequest.put("courseId", courseId);
        restTemplate.postForObject(notificationUrl, notificationRequest, String.class);

        return enrollment;
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }
}
