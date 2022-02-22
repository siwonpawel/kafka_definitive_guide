package com.github.siwonpawel.kafka.producer.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "spring.kafka.implementation", havingValue = "spring")
public class SpringKafkaService implements KafkaService
{

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override public void publish(String message)
    {
        kafkaTemplate.send("t-message", message);
    }

}
