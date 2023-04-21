package com.example.demo.logging;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.consumer.LogMessage;
import com.example.demo.producer.RabbitProducer;

@Component
@Scope("prototype")
public class LoggerWrapper {
	private Logger log;
	private LogMessage logMessage;
	@Autowired RabbitProducer producer;
	
	@Value("{spring.application.name}")
	private String appName;
	
	private <T> LoggerWrapper(Class<T> c, String functionality) {
		log= Logger.getLogger(c.getSimpleName());
		
		logMessage= new LogMessage();
		logMessage.setApplicationName(appName);
		logMessage.setClassName(c.getSimpleName());
		logMessage.setFunctionality(functionality);
		logMessage.setModuleName(c.getPackageName());
		
	}
	
	public <T> LoggerWrapper getLogger(Class<T> c, String functionality) {
		return new LoggerWrapper(c, functionality);
	}
	
	public void info(String message, String transactionId) {
		log.info(message);
		logMessage.setTransactionId(transactionId);
		logMessage.setMessage(message);
		logMessage.setLogLevel("INFO");
		producer.invia(logMessage);
	}
	
	public void warning(String message, String transactionId) {
		log.warning(message);
		logMessage.setTransactionId(transactionId);
		logMessage.setMessage(message);
		logMessage.setLogLevel("WARNING");
		producer.invia(logMessage);
	}
	public void debug(String message, String transactionId) {
		log.fine(message);
		logMessage.setTransactionId(transactionId);
		logMessage.setMessage(message);
		logMessage.setLogLevel("DEBUG");
		producer.invia(logMessage);
	}
	
	public void error(String message, String transactionId,String stackTrace) {
		log.severe(message);
		logMessage.setTransactionId(transactionId);
		logMessage.setMessage(message);
		logMessage.setStackTrace(stackTrace);
		logMessage.setLogLevel("ERROR");
		producer.invia(logMessage);
	}
	
}
