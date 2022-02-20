package com.github.siwonpawel.kafka.producer.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.siwonpawel.kafka.data.customdata.CustomData;
import com.github.siwonpawel.kafka.data.customdata.CustomDataService;
import com.github.siwonpawel.kafka.producer.kafka.KafkaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class CustomDataController
{

    private final CustomDataService customDataService;
    private final KafkaService kafkaService;

    @GetMapping
    public List<CustomData> getMessages(Pageable page)
    {
        return customDataService.getAll(page).getContent();
    }

    @PostMapping
    public CustomData produce(@RequestBody CustomData customData)
    {
        log.info("Sending data: " + customData.getContent());
        var result = customDataService.save(customData);
        kafkaService.publish(result.getContent());

        log.info("Sent!");
        return result;
    }
}
