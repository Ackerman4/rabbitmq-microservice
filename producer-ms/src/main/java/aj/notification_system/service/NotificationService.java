package aj.notification_system.service;

import aj.notification_system.dto.request.NotificationRequestDto;
import aj.notification_system.dto.response.NotificationResponseDto;

public interface NotificationService {
    NotificationResponseDto postNotification(NotificationRequestDto requestDto);
}
