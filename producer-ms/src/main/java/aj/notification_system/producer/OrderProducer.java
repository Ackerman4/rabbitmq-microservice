package aj.notification_system.producer;

import aj.notification_system.dto.domain.OrderDTO;

public interface OrderProducer {

    boolean sendOrder(OrderDTO orderDTO);
}
