package lk.ac.sjp.ict.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentNotificationRequest {
    private Long studentId;
    private Long courseId;
}
