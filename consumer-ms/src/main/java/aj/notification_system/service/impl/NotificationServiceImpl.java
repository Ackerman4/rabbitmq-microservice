package aj.notification_system.service.impl;

import aj.notification_system.dto.domain.NotificationDTO;
import aj.notification_system.dto.request.NotificationRequestDto;
import aj.notification_system.dto.response.NotificationResponseDto;
import aj.notification_system.factory.NotificationFactory;
import aj.notification_system.producer.NotificationProducer;
import aj.notification_system.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationProducer notificationProducer;

    private final NotificationFactory notificationFactory;

    @Override
    public NotificationResponseDto postNotification(NotificationRequestDto requestDto) {
        log.info("NotificationServiceImpl::postNotification");
        String id = UUID.randomUUID().toString();
        NotificationDTO notificationDTO = notificationFactory.buildNotificationDTO(requestDto, id);
        boolean isSentSuccessfully = notificationProducer.sendNotification(notificationDTO);
        return notificationFactory.buildNotificationResponseDto(id, isSentSuccessfully);
    }
}
