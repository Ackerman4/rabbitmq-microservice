package aj.notification_system.factory;

import aj.notification_system.dto.domain.NotificationDTO;
import aj.notification_system.dto.request.NotificationRequestDto;
import aj.notification_system.dto.response.NotificationResponseDto;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {

    public NotificationResponseDto buildNotificationResponseDto(String id, boolean messageStatus) {
        return new NotificationResponseDto(id, messageStatus);
    }

    public NotificationDTO buildNotificationDTO(NotificationRequestDto requestDto, String id) {
        return new NotificationDTO(
                id,
                requestDto.recipient(),
                requestDto.subject(),
                requestDto.message()
        );
    }
}
