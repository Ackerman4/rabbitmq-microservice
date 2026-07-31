package aj.notification_system.producer.impl;

import aj.notification_system.constants.RabbitMQConstants;
import aj.notification_system.dto.domain.NotificationDTO;
import aj.notification_system.dto.domain.OrderDTO;
import aj.notification_system.producer.NotificationProducer;
import aj.notification_system.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducerImpl implements OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public boolean sendOrder(OrderDTO orderDTO) {
        log.info("OrderProducer::sendOrder, RequestDTO = {}", orderDTO);
        try {
            rabbitTemplate.convertAndSend(
                    RabbitMQConstants.ORDER_EXCHANGE,
                    RabbitMQConstants.ORDER_ROUTING_KEY,
                    orderDTO
            );
            return true;
        } catch (AmqpException e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
