package aj.notification_system.dto.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderDTO(

        @NotBlank
        String referenceId,

        @NotBlank
        String orderId,

        @NotBlank
        String customerName,

        @NotNull
        String orderDate
) {
}
