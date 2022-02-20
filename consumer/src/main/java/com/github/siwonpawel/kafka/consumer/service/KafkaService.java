package com.github.siwonpawel.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.github.siwonpawel.kafka.data.customdata.CustomData;
import com.github.siwonpawel.kafka.data.customdata.CustomDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaService
{

    private final CustomDataService customDataService;

    @KafkaListener(topics = { "t-message" })
    public void process(String message)
    {
        log.info("Received: {}", message);
        var data = new CustomData();
        data.setContent(message);

        customDataService.save(data);
    }

}
