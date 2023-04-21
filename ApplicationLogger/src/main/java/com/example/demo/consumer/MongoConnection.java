package com.example.demo.consumer;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoConnection {


	private static final Logger logNormale = Logger.getLogger("MongoConnection");
	@Autowired
	private MyRepository repo;
	
	public void salva(LogMessage log) {
		logNormale.info("salvo il messaggio");
		repo.save(log);
	}
}
