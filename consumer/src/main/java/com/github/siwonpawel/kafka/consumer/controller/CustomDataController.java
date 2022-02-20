package com.github.siwonpawel.kafka.consumer.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.siwonpawel.kafka.data.customdata.CustomData;
import com.github.siwonpawel.kafka.data.customdata.CustomDataService;

@RestController
@RequestMapping("/data")
public class CustomDataController
{

    private final CustomDataService customDataService;

    public CustomDataController(CustomDataService customDataService)
    {
        this.customDataService = customDataService;
    }

    @GetMapping
    public List<CustomData> getMessages(Pageable page)
    {
        return customDataService.getAll(page).getContent();
    }

}
