package com.sample.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.kafka.model.CustomMessage;

@RestController
public class KafkaController {
	
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	@GetMapping("kafkatest")
	public String test() {
		CustomMessage msg = new CustomMessage("Yash", "Actor");
		kafkaTemplate.send("my-consumer-group", msg);
		return "Kafka Running bootstrap servers => ";
	}

}
