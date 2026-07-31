package aj.notification_system.consumer;

import aj.notification_system.dto.domain.NotificationDTO;

public interface NotificationConsumer {

    void consumerNotification(NotificationDTO notificationDTO);
}
