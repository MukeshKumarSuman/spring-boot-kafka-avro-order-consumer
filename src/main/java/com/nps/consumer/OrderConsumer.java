package com.nps.consumer;

import avro.schema.generated.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "orders-test", groupId = "${spring.kafka.consumer.group-id}")
    public void onMessage(ConsumerRecord<String, Order> consumerRecord) {
        logger.info("Consumed Record key={}, value={}", consumerRecord.key(), consumerRecord.value());
    }
}
