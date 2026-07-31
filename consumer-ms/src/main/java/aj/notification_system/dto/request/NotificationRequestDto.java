package aj.notification_system.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NotificationRequestDto(

        @NotBlank
        String recipient,

        @NotBlank
        String subject,

        @NotNull
        String message
) {
}
