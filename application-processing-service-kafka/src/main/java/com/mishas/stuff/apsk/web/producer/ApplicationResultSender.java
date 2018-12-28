package com.mishas.stuff.apsk.web.producer;

import com.mishas.stuff.common.web.ApplicationResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class ApplicationResultSender {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationResultSender.class);
    private KafkaTemplate<String, ApplicationResultDto> template;

    @Value(value = "${application.producer.topic.name}")
    private String applicationTopicName;

    @Autowired
    public void setTemplate(KafkaTemplate<String, ApplicationResultDto> template) {
        this.template = template;
    }

    public void send(final ApplicationResultDto applicationResultDto) {
        logger.info("sending Application Results Payload='{}'", applicationResultDto.toString());
        template.send(applicationTopicName, applicationResultDto);
    }
}
