package com.example.demo.producer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logging.LoggerWrapper;

import jakarta.annotation.PostConstruct;

@Service
@RestController
@RequestMapping("/api/final")
public class MyRestController {

	private LoggerWrapper log;
	
	@Autowired BeanFactory beanFactory;
	
	@PostConstruct
	public void init() {
		log= beanFactory.getBean(LoggerWrapper.class, MyRestController.class,"testing");
	}
	
	@PostMapping("/invia")
	public void invia() {
		log.info("provo ad inviare un messaggio", null);
		log.error("provo ad inviare un messaggio di errore","idError","primo messaggio di errore");
		log.debug("provo ad inviare un messaggio di debug", null);
		log.warning("provo ad inviare un messaggio di warning", "idWarning");
	}
}
