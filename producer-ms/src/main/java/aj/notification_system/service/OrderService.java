package aj.notification_system.service;

import aj.notification_system.dto.request.OrderRequestDto;
import aj.notification_system.dto.response.OrderResponseDto;

public interface OrderService {
    OrderResponseDto postOrder(OrderRequestDto requestDto);
}
