package com.example.demo.consumer;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("LogMessages")
@Getter
@Setter
@NoArgsConstructor
public class LogMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String applicationName;
	private String moduleName;
	private String className;
	private String functionality;
	private String transactionId;
	private String message;
	private String stackTrace;
	private String logLevel;
		
	@Override
	public String toString() {
		return "{\"applicationName\":\"" + applicationName + "\", \"moduleName\":\"" + moduleName + "\", \"className\":\"" + className
				+ "\", \"functionality\":\"" + functionality + "\", \"transactionId\":\"" + transactionId + "\", \"message\":\"" + message
				+ "\", \"stackTrace\":\"" + stackTrace + "\", \"logLevel\":\"" + logLevel + "\"}";
	}

}
