package com.github.siwonpawel.kafka.consumer.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.siwonpawel.kafka.data.message.CustomData;
import com.github.siwonpawel.kafka.data.message.MessageService;

@RestController
@RequestMapping("/data")
public class CustomDataController
{

    private final MessageService messageService;

    public CustomDataController(MessageService messageService)
    {
        this.messageService = messageService;
    }

    @GetMapping
    public List<CustomData> getMessages(Pageable page)
    {
        return messageService.getMessages(page).getContent();
    }

}
