package com.sample.kafka.produce.consume;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "my-consumer-group", containerFactory = "kafkaListenerContainerFactory", groupId = "my-consumer-group")
	public void consumeEvent(@Payload Object consumeData) {
		System.out.println("In Kafka Consumer");
		ConsumerRecord record = (ConsumerRecord) consumeData;
		System.out.println("Data => "+ record.value().toString());
	}
}
