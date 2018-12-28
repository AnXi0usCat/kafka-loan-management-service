package com.mishas.stuff.apsk.service.impl;

import com.mishas.stuff.apsk.service.ApplicationProcessingService;
import com.mishas.stuff.common.web.ApplicationDto;
import com.mishas.stuff.common.web.ApplicationResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ApplicationProcessingServiceImpl implements ApplicationProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationProcessingService.class.getName());

    @Override
    public ApplicationResultDto processApplication(ApplicationDto applicationDto) {
        return new ApplicationResultDto(applicationDto.getId(), lendingDecision(), applicationDto.getLoanAmount());
    }


    private boolean lendingDecision() {
        boolean willLend =  Math.random() > 0.75 ? true : false;
        logger.info("application successful: " + willLend);
        return willLend;
    }
}
