package com.example.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoConnection {

	@Autowired
	private MyRepository repo;
	
	public void salva(LogMessage log) {
		System.out.println("---------salvo il messaggio");
		repo.save(log);
	}
}
