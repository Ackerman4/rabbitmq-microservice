package aj.notification_system.enums;

import org.springframework.http.HttpStatus;

public interface NotificationErrorResponse {
    String getErrorCode();
    String getErrorMessage();
    HttpStatus getHttpStatus();
}
