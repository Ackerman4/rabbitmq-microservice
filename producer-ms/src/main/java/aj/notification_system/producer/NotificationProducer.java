package aj.notification_system.producer;

import aj.notification_system.dto.domain.NotificationDTO;

public interface NotificationProducer {

    boolean sendNotification(NotificationDTO requestDto);
}
