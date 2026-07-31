package aj.notification_system.dto.response;

public record ApiErrorResponse(
        String errorCode,
        String errorMessage
) {
}
