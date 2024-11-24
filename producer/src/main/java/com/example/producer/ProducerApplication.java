package com.example.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ProducerApplication {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerApplication(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        kafkaTemplate.send("topic1", "Hello from Producer");
        kafkaTemplate.send("topic2", "Hello from Producer with partitions");
    }
}