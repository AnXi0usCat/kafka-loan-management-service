package com.mishas.stuff.acsk.service;

import com.mishas.stuff.common.web.ApplicationDto;

public interface ApplicationCreationService {

    ApplicationDto createApplication(String firstname, String surname, Integer loanAmount);
}
