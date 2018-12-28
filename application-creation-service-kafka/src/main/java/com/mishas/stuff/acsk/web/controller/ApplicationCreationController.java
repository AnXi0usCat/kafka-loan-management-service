package com.mishas.stuff.acsk.web.controller;

import com.mishas.stuff.acsk.service.ApplicationCreationService;
import com.mishas.stuff.acsk.web.producer.ApplicationSender;
import com.mishas.stuff.common.web.ApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationCreationController {

    private ApplicationCreationService service;
    private ApplicationSender sender;

    @RequestMapping(value = "/api/v1/application", method = RequestMethod.GET)
    @ResponseBody
    public ApplicationDto createApplication(
            @RequestParam(value = "firstname") final String firstname,
            @RequestParam(value = "surname") final String surname,
            @RequestParam(value = "loanAmount") final Integer loanAmount
    ) {
        ApplicationDto appDto = service.createApplication(firstname, surname, loanAmount);
        // send result to kafka broker
        sender.send(appDto);
        // return application to the client
        return appDto;
    }

    @Autowired
    public void setService(ApplicationCreationService service) {
        this.service = service;
    }

    @Autowired
    public void setSender(ApplicationSender sender) { this.sender = sender; }
}
