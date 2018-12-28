package com.mishas.stuff.misk.web.consumer;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.misk.service.impl.MoneyIssuingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class ApplicationResultReceiver {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationResultReceiver.class);
    private MoneyIssuingServiceImpl moneyIssuingService;

    @KafkaListener(topics = "loan", containerFactory = "kafkaListenerContainerFactory")
    public void receive(ApplicationResultDto applicationResultDto) {

        logger.info("Received Message in group: money_issuing"  + applicationResultDto.toString());
        moneyIssuingService.issueMoney(applicationResultDto);
    }

    @Autowired
    public void setMoneyIssuingService(MoneyIssuingServiceImpl moneyIssuingService) {
        this.moneyIssuingService = moneyIssuingService;
    }
}
