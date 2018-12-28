package com.mishas.stuff.misk.service.impl;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.misk.service.MoneyIssuingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MoneyIssuingServiceImpl implements MoneyIssuingService {

    private static final Logger logger = LoggerFactory.getLogger(MoneyIssuingServiceImpl.class.getName());

    @Override
    public void issueMoney(ApplicationResultDto applicationResultDto) {
        logger.info(
                "Issuing loan: " + applicationResultDto.getApplicationId() +
                        ". The amount is: " + applicationResultDto.getLoanAmount());
    }
}
