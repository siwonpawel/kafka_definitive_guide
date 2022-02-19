package com.github.siwonpawel.kafka.producer.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.siwonpawel.kafka.data.message.CustomData;
import com.github.siwonpawel.kafka.data.message.MessageService;
import com.github.siwonpawel.kafka.producer.kafka.KafkaService;

@RestController
@RequestMapping("/data")
public class CustomDataController
{

    private final MessageService messageService;
    private final KafkaService kafkaService;

    public CustomDataController(MessageService messageService, KafkaService kafkaService)
    {
        this.messageService = messageService;
        this.kafkaService = kafkaService;
    }

    @GetMapping
    public List<CustomData> getMessages(Pageable page)
    {
        return messageService.getMessages(page).getContent();
    }

    @PostMapping
    public CustomData produce(@RequestBody CustomData customData)
    {
        var result = messageService.produce(customData);
        kafkaService.publish(result.toString());

        return result;
    }
}
