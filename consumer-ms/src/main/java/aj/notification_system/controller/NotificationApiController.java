package aj.notification_system.controller;

import aj.notification_system.dto.request.NotificationRequestDto;
import aj.notification_system.dto.response.NotificationResponseDto;
import aj.notification_system.service.NotificationService;
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
@RequestMapping("/api/v1/notifications")
public class NotificationApiController {

    private final NotificationService notificationService;

    @PostMapping("/")
    public ResponseEntity<NotificationResponseDto> postNotification(@RequestBody NotificationRequestDto requestDto) {
        log.info("NotificationApiController::postNotification, requestDto={}", requestDto);
        return ResponseEntity.ok(notificationService.postNotification(requestDto));
    }
}
