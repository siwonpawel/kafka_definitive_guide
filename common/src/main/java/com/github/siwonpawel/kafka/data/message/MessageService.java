package com.github.siwonpawel.kafka.data.message;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService
{

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository)
    {
        this.messageRepository = messageRepository;
    }

    public Page<CustomData> getMessages(Pageable page)
    {
        return messageRepository.findAll(page);
    }

    public CustomData produce(CustomData customData)
    {
        return messageRepository.save(customData);
    }
}
