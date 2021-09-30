package com.example.rabbitmqproducer.service;

import com.example.rabbitmqproducer.configs.ConfigureRabbitMq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProduceMessageService {

    private final RabbitTemplate rabbitTemplate;

    public ProduceMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String produceMessage(String message) {
        rabbitTemplate.convertAndSend(ConfigureRabbitMq.EXCHANGE_NAME, "myRoutingKey.messages",
                message);
        return "Message(" + message + ")" + " has been produced.";
    }
}
