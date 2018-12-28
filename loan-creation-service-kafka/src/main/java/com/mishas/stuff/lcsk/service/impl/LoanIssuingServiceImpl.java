package com.mishas.stuff.lcsk.service.impl;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.common.web.LoanDto;
import com.mishas.stuff.lcsk.service.LoanIssuingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoanIssuingServiceImpl implements LoanIssuingService {

    private static final Logger logger = LoggerFactory.getLogger(LoanIssuingServiceImpl.class.getName());

    @Override
    public LoanDto createLoan(ApplicationResultDto applicatioResultDto) {
        LoanDto loan = new LoanDto(
                applicatioResultDto.getApplicationId(),
                false,
                applicatioResultDto.getLoanAmount()
        );
        logger.info("New Loan has been created: " + loan.getLoanId() + " with the ammount: " +loan.getLoanAmont());
        return loan;
    }
}
