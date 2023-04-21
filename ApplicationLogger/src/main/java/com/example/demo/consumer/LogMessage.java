package com.example.demo.consumer;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("LogMessages")
@Getter
@Setter
@NoArgsConstructor
public class LogMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String applicationName;
	private String moduleName;
	private String className;
	private String functionality;
	private String transactionId;
	private String message;
	private String stackTrace;
	private String logLevel;
	public LogMessage(String applicationName, String moduleName, String className, String functionality,
			String transactionId, String message, String stackTrace, String logLevel) {
		super();
		this.applicationName = applicationName;
		this.moduleName = moduleName;
		this.className = className;
		this.functionality = functionality;
		this.transactionId = transactionId;
		this.message = message;
		this.stackTrace = stackTrace;
		this.logLevel = logLevel;
	}
	@Override
	public String toString() {
		return "{\"id\":\""+id+"\",\"applicationName\":\"" + applicationName + "\", \"moduleName\":\"" + moduleName + "\", \"className\":\"" + className
				+ "\", \"functionality\":\"" + functionality + "\", \"transactionId\":\"" + transactionId + "\", \"message\":\"" + message
				+ "\", \"stackTrace\":\"" + stackTrace + "\", \"logLevel\":\"" + logLevel + "\"}";
	}
	
	
}
