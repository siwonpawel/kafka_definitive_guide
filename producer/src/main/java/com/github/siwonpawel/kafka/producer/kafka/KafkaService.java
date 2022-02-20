package com.github.siwonpawel.kafka.producer.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaService
{

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publish(String message)
    {
        kafkaTemplate.send("t-message", message);
    }

}
