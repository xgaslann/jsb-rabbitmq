package com.xgaslan.rabbitmq.publisher;

import com.xgaslan.rabbitmq.constants.RabbitMQConstants;
import com.xgaslan.rabbitmq.model.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user) {
        log.info("Producing JSON message: {}", user);
        rabbitTemplate.convertAndSend(RabbitMQConstants.EXCHANGE_NAME, RabbitMQConstants.JSON_ROUTING_KEY, user);
    }
}
