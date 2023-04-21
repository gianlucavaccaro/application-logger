package com.example.demo.consumer;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Consumer {
	LogMessage event;
	
	@Autowired
	MongoConnection conn;
	
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumeMessage(Message logMessage){
        System.out.println("------sono consumer, messaggio ricevuto");
		deserealizza(logMessage);
        conn.salva(event);
    }

	private void deserealizza(Message logMessage) {
		ObjectMapper objectMapper= new ObjectMapper();
		try {
			 event = objectMapper.readValue(logMessage.getBody(), LogMessage.class);
			 System.out.println("------sono consumer, messaggio: appName: "+event.getApplicationName());
		}  catch (IOException e) {
			System.err.println("------ERRORE NELLA DESEREALIZZAZIONE ");
			e.printStackTrace();
		}
		
	}
}
