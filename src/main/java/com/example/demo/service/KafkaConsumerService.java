package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumerService {

	
	@KafkaListener(topics = "yourTopic",groupId = "myGroup")
	public String readKafkaProducer(String data) {
		
		System.out.println("Read Config TOPIC "+data);
		return data;
	}
	
}
