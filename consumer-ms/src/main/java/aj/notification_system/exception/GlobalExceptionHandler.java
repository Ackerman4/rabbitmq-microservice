package aj.notification_system.exception;

import aj.notification_system.dto.response.ApiErrorResponse;
import aj.notification_system.factory.ApiErrorResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ApiErrorResponseFactory apiErrorResponseFactory;

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
//
//    }

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<ApiErrorResponse> handleNotificationException(NotificationException exception) {
        ApiErrorResponse apiErrorResponse = apiErrorResponseFactory.buildApiErrorResponse(exception);
        return new ResponseEntity<>(apiErrorResponse, exception.getHttpStatus());
    }
}
