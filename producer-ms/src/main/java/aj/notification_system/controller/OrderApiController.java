package aj.notification_system.controller;

import aj.notification_system.dto.request.NotificationRequestDto;
import aj.notification_system.dto.request.OrderRequestDto;
import aj.notification_system.dto.response.NotificationResponseDto;
import aj.notification_system.dto.response.OrderResponseDto;
import aj.notification_system.service.NotificationService;
import aj.notification_system.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/orders")
public class OrderApiController {

    private final OrderService notificationService;

    @PostMapping("/")
    public ResponseEntity<OrderResponseDto> postOrder(@RequestBody OrderRequestDto orderRequestDto) {
        log.info("OrderApiController::postOrder, requestDto={}", orderRequestDto);
        return ResponseEntity.ok(notificationService.postOrder(orderRequestDto));
    }
}
