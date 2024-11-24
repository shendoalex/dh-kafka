package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @KafkaListener(topics = "topic1", groupId = "group1")
    public void listenTopic1(String message) {
        System.out.println("Received message from topic1: " + message);
    }

    @KafkaListener(topics = "topic2", groupId = "group2")
    public void listenTopic2(String message) {
        System.out.println("Received message from topic2: " + message);
    }
}