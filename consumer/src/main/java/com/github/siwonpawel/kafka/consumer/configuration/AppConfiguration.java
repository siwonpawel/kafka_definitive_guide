package com.github.siwonpawel.kafka.consumer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.siwonpawel.kafka.data.DataConfiguration;

@Configuration
@Import({
        DataConfiguration.class,
})
public class AppConfiguration
{
}
