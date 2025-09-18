package com.xgaslan.rabbitmq.controller;

import com.xgaslan.rabbitmq.publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQProducer producer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ: " + message);
    }
}
