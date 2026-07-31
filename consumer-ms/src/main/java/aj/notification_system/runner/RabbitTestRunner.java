package aj.notification_system.runner;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitTestRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public RabbitTestRunner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {

        rabbitTemplate.execute(channel -> {
            System.out.println("Successfully opened RabbitMQ channel!");
            return null;
        });

    }
}
