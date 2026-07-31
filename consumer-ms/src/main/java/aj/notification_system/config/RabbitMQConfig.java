package aj.notification_system.config;

import aj.notification_system.constants.RabbitMQConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue notificationQueue() {
        return QueueBuilder
                .durable(RabbitMQConstants.NOTIFICATION_QUEUE)
                .build();
    }

    @Bean
    public DirectExchange notificationExchange() {
        return new DirectExchange(RabbitMQConstants.NOTIFICATION_EXCHANGE);
    }

    @Bean
    public Binding notificationBinding(Queue notificationQueue, DirectExchange notificationExchange) {
        return BindingBuilder
                .bind(notificationQueue)
                .to(notificationExchange)
                .with(RabbitMQConstants.NOTIFICATION_ROUTING_KEY);
    }

    @Bean
    public Queue orderQueue() {
        return QueueBuilder
                .durable(RabbitMQConstants.ORDER_QUEUE)
                .build();
    }

    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(RabbitMQConstants.ORDER_EXCHANGE);
    }

    @Bean
    public Binding orderBinding(Queue orderQueue, DirectExchange orderExchange) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderExchange)
                .with(RabbitMQConstants.ORDER_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jacksonMessageConverter() {
        return new JacksonJsonMessageConverter("*");
    }
}
