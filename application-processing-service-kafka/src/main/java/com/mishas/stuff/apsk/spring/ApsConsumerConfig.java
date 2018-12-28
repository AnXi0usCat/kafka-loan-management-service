package com.mishas.stuff.apsk.spring;

import com.mishas.stuff.apsk.web.consumer.ApplicationReceiver;
import com.mishas.stuff.common.web.ApplicationDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@ComponentScan({"com.mishas.stuff.apsk.web.consumer"})
public class ApsConsumerConfig {

    @Value(value="${kafka.bootstrapAddress}")
    private String bootstrapAddress;
    @Value(value="${application.consumer.group.name}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, ApplicationDto> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(ApplicationDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ApplicationDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ApplicationDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ApplicationReceiver receiver() {
        return new ApplicationReceiver();
    }
}
