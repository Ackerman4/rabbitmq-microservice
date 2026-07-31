package aj.notification_system.consumer.impl;

import aj.notification_system.constants.RabbitMQConstants;
import aj.notification_system.consumer.NotificationConsumer;
import aj.notification_system.dto.domain.NotificationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationConsumerImpl implements NotificationConsumer {

    @Override
    @RabbitListener(queues = RabbitMQConstants.NOTIFICATION_QUEUE)
    public void consumeNotification(NotificationDTO notificationDTO) {
        log.info("Received Notification: {}", notificationDTO);
    }
}
