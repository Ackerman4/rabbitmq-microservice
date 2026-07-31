package aj.notification_system.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OrderResponseDto(

        String referenceId,

        Boolean orderSuccess

) {
}
