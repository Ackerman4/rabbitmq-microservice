package aj.notification_system.dto.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NotificationDTO(

        @NotBlank
        String id,

        @NotBlank
        String recipient,

        @NotBlank
        String subject,

        @NotNull
        String message
) {
}
