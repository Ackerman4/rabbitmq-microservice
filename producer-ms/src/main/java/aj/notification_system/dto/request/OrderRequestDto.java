package aj.notification_system.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequestDto(

        @NotBlank
        String orderId,

        @NotBlank
        String customerName,

        @NotNull
        String orderDate
) {
}
