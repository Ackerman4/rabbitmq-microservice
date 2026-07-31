package aj.notification_system.consumer.impl;

import aj.notification_system.constants.RabbitMQConstants;
import aj.notification_system.consumer.OrderConsumer;
import aj.notification_system.dto.domain.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderConsumerImpl implements OrderConsumer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    @Scheduled(fixedRate = 5000)
    public void consumeOrder() {
        OrderDTO orderDTO = (OrderDTO) rabbitTemplate.receiveAndConvert(
                RabbitMQConstants.ORDER_QUEUE
        );

        if (Objects.isNull(orderDTO)) {
            return;
        }
        log.info("OrderConsumer::consumeOrder = Processing Order = {}", orderDTO);
    }
}
