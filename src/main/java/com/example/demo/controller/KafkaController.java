package com.example.demo.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KafkaProducerService;

@RestController
public class KafkaController {
	
	@Autowired
	KafkaProducerService service;
	@GetMapping("/kafka")
	public String produceMsgToKafka(@RequestParam String msg) throws InterruptedException, ExecutionException, TimeoutException {
		
		service.produceMessagetoKafka(msg);
		return "Message Post Successfully...!!!  " + msg;
		
	}
}
