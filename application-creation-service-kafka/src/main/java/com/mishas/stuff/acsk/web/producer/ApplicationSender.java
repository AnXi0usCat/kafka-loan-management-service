package com.mishas.stuff.acsk.web.producer;


import com.mishas.stuff.common.web.ApplicationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class ApplicationSender {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationSender.class);
    private KafkaTemplate<String, ApplicationDto> template;

    @Value(value = "${application.topic.name}")
    private String applicationTopicName;

    @Autowired
    public void setTemplate(KafkaTemplate<String, ApplicationDto> template) {
        this.template = template;
    }

    public void send(final ApplicationDto applicationDto) {
        logger.info("sending payload='{}'", applicationDto.toString());
        template.send(applicationTopicName, applicationDto);
    }
}
