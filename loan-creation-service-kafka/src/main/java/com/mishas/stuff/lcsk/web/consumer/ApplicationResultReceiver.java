package com.mishas.stuff.lcsk.web.consumer;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.common.web.LoanDto;
import com.mishas.stuff.lcsk.service.LoanIssuingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class ApplicationResultReceiver {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationResultReceiver.class);
    private LoanIssuingService loanIssuingService;


    @KafkaListener(topics = "loan", containerFactory = "kafkaListenerContainerFactory")
    public void receive(ApplicationResultDto applicationResultDto) {

        logger.info("Received Message in group: lending"  + applicationResultDto.toString());
        LoanDto loanDto = loanIssuingService.createLoan(applicationResultDto);
        logger.info("loan has been recorded" + loanDto.toString());
    }

    @Autowired
    public void setLoanIssuingService(LoanIssuingService loanIssuingService) {
        this.loanIssuingService = loanIssuingService;
    }

}
