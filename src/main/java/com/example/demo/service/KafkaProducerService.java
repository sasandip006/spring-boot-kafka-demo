package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void produceMessagetoKafka(String msg) throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<SendResult<String, String>> future=kafkaTemplate.send("yourTopic",msg);
		
		SendResult<String, String> res=future.get(3, TimeUnit.SECONDS);
		String topic=res.getProducerRecord().topic();
		int part =res.getRecordMetadata().partition();
		System.out.println("Partition : "+topic+"  : "+part);
	}

}
