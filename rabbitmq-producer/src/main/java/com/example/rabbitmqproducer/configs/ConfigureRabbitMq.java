package com.example.rabbitmqproducer.configs;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ConfigureRabbitMq {

    public static final String QUEUE_NAME = "publisher";
    public static final String EXCHANGE_NAME = "ex-hello";

    /*
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
    List<Binding> bindings() {

        List<String> lstQueues = new ArrayList<>();
        lstQueues.add("hello_4c654958-5430-4b66-a9e5-67e73a3978f4");
        lstQueues.add("hello_6d1f6e5b-8fb6-49c6-9096-60c9c4902917");

        List<Binding> lstBidings = new ArrayList<>();

        for(String queue : lstQueues)
        {
            lstBidings.add(BindingBuilder.bind(new Queue(queue)).to(exchange()));
        }


        return lstBidings;
    }


    @Bean
    public Declarables fanoutBindings() {
        Queue fanoutQueue1 = new Queue("hello_4c654958-5430-4b66-a9e5-67e73a3978f4", true);
        Queue fanoutQueue2 = new Queue("hello_6d1f6e5b-8fb6-49c6-9096-60c9c4902917", true);
        Queue fanoutQueue3 = new Queue("hello_947c5b75-fcec-4922-b1d3-0159a75b5117", true);

        FanoutExchange fanoutExchange = new FanoutExchange(EXCHANGE_NAME);

        return new Declarables(
                fanoutQueue1,
                fanoutQueue2,
                fanoutQueue3,
                fanoutExchange,
                BindingBuilder.bind(fanoutQueue1).to(fanoutExchange),
                BindingBuilder.bind(fanoutQueue2).to(fanoutExchange),
                BindingBuilder.bind(fanoutQueue3).to(fanoutExchange)
                );
    }*/

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }
}