package aj.notification_system.producer.impl;

import aj.notification_system.constants.RabbitMQConstants;
import aj.notification_system.dto.domain.NotificationDTO;
import aj.notification_system.producer.NotificationProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducerImpl implements NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public boolean sendNotification(NotificationDTO notificationDTO) {
        log.info("NotificationProducer::sendNotification, RequestDTO = {}", notificationDTO);
        try {
            rabbitTemplate.convertAndSend(
                    RabbitMQConstants.NOTIFICATION_EXCHANGE,
                    RabbitMQConstants.NOTIFICATION_ROUTING_KEY,
                    notificationDTO
            );
            return true;
        } catch (AmqpException e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
