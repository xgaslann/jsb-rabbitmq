package com.xgaslan.rabbitmq.consumer;

import com.xgaslan.rabbitmq.constants.RabbitMQConstants;
import com.xgaslan.rabbitmq.model.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQJsonConsumer {

    @RabbitListener(
            queues = {RabbitMQConstants.JSON_QUEUE_NAME}
    )
    public void consumeJsonMessage(User user) {
        log.info("Consuming JSON message: {}", user);
    }
}
