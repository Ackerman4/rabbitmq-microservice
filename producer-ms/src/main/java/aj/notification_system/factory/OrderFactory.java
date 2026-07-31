package aj.notification_system.factory;

import aj.notification_system.dto.domain.OrderDTO;
import aj.notification_system.dto.request.OrderRequestDto;
import aj.notification_system.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {

    public OrderResponseDto buildOrderResponseDto(String referenceId, boolean orderSuccess) {
        return new OrderResponseDto(referenceId, orderSuccess);
    }

    public OrderDTO buildOrderDTO(OrderRequestDto requestDto, String referenceId) {
        return new OrderDTO(
                referenceId,
                requestDto.orderId(),
                requestDto.customerName(),
                requestDto.orderDate()
        );
    }
}
