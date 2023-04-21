package com.example.demo.consumer;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Consumer {
	LogMessage event;
	
	private static final Logger logNormale = Logger.getLogger("RabbitConsumer");
	
	@Autowired
	MongoConnection conn;
	
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumeMessage(Message msg){
		logNormale.info("messaggio ricevuto");
		deserealizza(msg);
        conn.salva(event);
    }

	private void deserealizza(Message msg) {
		ObjectMapper objectMapper= new ObjectMapper();
		try {
			 event = objectMapper.readValue(msg.getBody(), LogMessage.class);
			 logNormale.info("appName: "+event.getApplicationName());
		}  catch (IOException e) {
			System.err.println("------ERRORE NELLA DESEREALIZZAZIONE ");
			e.printStackTrace();
		}
		
	}
}
