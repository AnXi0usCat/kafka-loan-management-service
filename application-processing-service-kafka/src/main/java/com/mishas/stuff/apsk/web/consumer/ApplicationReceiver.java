package com.mishas.stuff.apsk.web.consumer;

import com.mishas.stuff.apsk.service.ApplicationProcessingService;
import com.mishas.stuff.apsk.web.producer.ApplicationResultSender;
import com.mishas.stuff.common.web.ApplicationDto;
import com.mishas.stuff.common.web.ApplicationResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class ApplicationReceiver {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationReceiver.class);
    private ApplicationProcessingService applicationProcessingService;
    private ApplicationResultSender applicationResultSender;

    @KafkaListener(topics = "application", containerFactory = "kafkaListenerContainerFactory")
    public void receive(ApplicationDto applicationDto) {

        logger.info("Received Message in group: processing"  + applicationDto.toString());
        ApplicationResultDto applicationResultDto = applicationProcessingService.processApplication(applicationDto);
        applicationResultSender.send(applicationResultDto);
    }

    @Autowired
    public void setApplicationProcessingService(ApplicationProcessingService applicationProcessingService) {
        this.applicationProcessingService = applicationProcessingService;
    }

    @Autowired
    public void setApplicationResultSender(ApplicationResultSender applicationResultSender) {
        this.applicationResultSender = applicationResultSender;
    }
}
