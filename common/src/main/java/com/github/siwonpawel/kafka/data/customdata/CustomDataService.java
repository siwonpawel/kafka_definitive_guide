package com.github.siwonpawel.kafka.data.customdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomDataService
{

    private final CustomDataRepository messageRepository;

    public Page<CustomData> getAll(Pageable page)
    {
        return messageRepository.findAll(page);
    }

    public CustomData save(CustomData customData)
    {
        return messageRepository.save(customData);
    }
}
