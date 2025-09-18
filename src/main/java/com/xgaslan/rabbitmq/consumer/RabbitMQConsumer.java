package com.xgaslan.rabbitmq.consumer;

import com.xgaslan.rabbitmq.constants.RabbitMQConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {

    @RabbitListener(
              queues = {RabbitMQConstants.QUEUE_NAME}
    )
    public void consumeMessage(String message) {
        log.info("Consuming message: {}", message);
    }
}
