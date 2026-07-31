package aj.notification_system.service.impl;

import aj.notification_system.dto.domain.NotificationDTO;
import aj.notification_system.dto.domain.OrderDTO;
import aj.notification_system.dto.request.OrderRequestDto;
import aj.notification_system.dto.response.OrderResponseDto;
import aj.notification_system.factory.OrderFactory;
import aj.notification_system.producer.OrderProducer;
import aj.notification_system.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderProducer orderProducer;

    private final OrderFactory orderFactory;

    @Override
    public OrderResponseDto postOrder(OrderRequestDto requestDto) {
        log.info("OrderResponseDto::postOrder");
        String referenceId = UUID.randomUUID().toString();
        OrderDTO orderDTO = orderFactory.buildOrderDTO(requestDto, referenceId);
        boolean isPlacedSuccessfully = orderProducer.sendOrder(orderDTO);
        return orderFactory.buildOrderResponseDto(referenceId, isPlacedSuccessfully);
    }
}
