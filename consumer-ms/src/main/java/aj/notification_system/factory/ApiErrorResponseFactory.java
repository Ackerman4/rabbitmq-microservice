package aj.notification_system.factory;

import aj.notification_system.dto.response.ApiErrorResponse;
import aj.notification_system.exception.NotificationException;
import org.springframework.stereotype.Component;

@Component
public class ApiErrorResponseFactory {

    public ApiErrorResponse buildApiErrorResponse(NotificationException exception) {
        return new ApiErrorResponse(exception.getErrorCode(), exception.getErrorMessage());
    }
}
