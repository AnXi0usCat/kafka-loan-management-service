package com.mishas.stuff.lcsk.service;

import com.mishas.stuff.common.web.ApplicationResultDto;
import com.mishas.stuff.common.web.LoanDto;

public interface LoanIssuingService {

    LoanDto createLoan(ApplicationResultDto applicatioResultDto);
}
