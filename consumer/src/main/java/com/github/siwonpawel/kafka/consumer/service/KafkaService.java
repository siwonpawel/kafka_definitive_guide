package com.github.siwonpawel.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService
{

    @KafkaListener(topics = { "t-message" })
    public void process(String message)
    {
        // TODO handle recived messages
    }

}
