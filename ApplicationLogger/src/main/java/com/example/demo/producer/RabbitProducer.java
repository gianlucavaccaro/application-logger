package com.example.demo.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.consumer.LogMessage;

@Service
public class RabbitProducer {
	@Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    
    private RabbitTemplate rabbitTemplate;

    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void invia(LogMessage log) {
    	System.out.println("-------------sono il producer, provo ad inviare il messaggio ");
    	rabbitTemplate.convertAndSend(exchange, routingKey, log.toString());
    }
	
}
