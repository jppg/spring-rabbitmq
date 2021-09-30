package com.example.rabbitmqproducer.configs;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureRabbitMq {

    public static final String QUEUE_NAME = "hello";
    public static final String EXCHANGE_NAME = "ex-hello";

    @Bean
    Queue createQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }
}