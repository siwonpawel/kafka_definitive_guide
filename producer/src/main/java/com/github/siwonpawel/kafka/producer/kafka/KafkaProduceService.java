package com.github.siwonpawel.kafka.producer.kafka;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConfigurationProperties("spring.kafka.producer")
@ConditionalOnProperty(name = "spring.kafka.implementation", havingValue = "native")
public class KafkaProduceService implements KafkaService
{
    @Setter
    private String bootstrapServers;
    @Setter
    private String keySerializer;
    @Setter
    private String valueSerializer;

    private KafkaProducer<String, String> kafkaProducer;

    @PostConstruct
    public void init()
    {
        var properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("key.serializer", keySerializer);
        properties.put("value.serializer", valueSerializer);

        kafkaProducer = new KafkaProducer<>(properties);
    }

    @Override
    public void publish(String message)
    {
        var message = new ProducerRecord<>("t-message", message, message);
        kafkaProducer.send(message, new ProducerCallback());
    }

    static class ProducerCallback implements Callback
    {

        @Override public void onCompletion(RecordMetadata metadata, Exception exception)
        {
            if (exception != null)
            {
                log.error("Error sending message to Kafka.", exception);
            }
        }
    }
}
