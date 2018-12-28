package com.mishas.stuff.misk.spring;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.misk.web.consumer.ApplicationResultReceiver;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan({"com.mishas.stuff.misk.web.consumer"})
public class MisConsumerConfig {

    @Value(value="${kafka.bootstrapAddress}")
    private String bootstrapAddress;
    @Value(value="${application.consumer.group.name}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, ApplicationResultDto> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(ApplicationResultDto.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ApplicationResultDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ApplicationResultDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ApplicationResultReceiver receiver() {
        return new ApplicationResultReceiver();
    }
}
