package com.example.demo.consumer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyRepository extends MongoRepository<LogMessage, String> {

}
