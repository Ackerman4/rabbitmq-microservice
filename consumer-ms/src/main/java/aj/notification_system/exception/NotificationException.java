package aj.notification_system.exception;

import aj.notification_system.enums.NotificationErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotificationException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;

    public NotificationException(NotificationErrorResponse notificationErrorResponse) {
        this.errorCode = notificationErrorResponse.getErrorCode();
        this.errorMessage = notificationErrorResponse.getErrorMessage();
        this.httpStatus = notificationErrorResponse.getHttpStatus();
    }
}
