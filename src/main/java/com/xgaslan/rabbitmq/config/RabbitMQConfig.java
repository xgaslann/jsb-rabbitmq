package com.xgaslan.rabbitmq.config;

import com.xgaslan.rabbitmq.constants.RabbitMQConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue(RabbitMQConstants.QUEUE_NAME, true);
    }

    @Bean
    public Queue jsonQueue(){
        return new Queue(RabbitMQConstants.JSON_QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(RabbitMQConstants.EXCHANGE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(RabbitMQConstants.ROUTING_KEY);
    }

    @Bean
    public Binding jsonBinding(){
        return BindingBuilder.bind(jsonQueue()).to(exchange()).with(RabbitMQConstants.JSON_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
