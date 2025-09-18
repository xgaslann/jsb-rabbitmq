package com.xgaslan.rabbitmq.controller;

import com.xgaslan.rabbitmq.model.dto.User;
import com.xgaslan.rabbitmq.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json-messages")
@RequiredArgsConstructor
public class MessageJsonController {
    private final RabbitMQJsonProducer producer;

    @PostMapping
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        producer.sendJsonMessage(user);
        return ResponseEntity.ok("JSON Message sent to RabbitMQ: " + user);
    }

}
