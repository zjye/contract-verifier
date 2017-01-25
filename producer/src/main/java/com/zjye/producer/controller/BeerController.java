package com.zjye.producer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

    private final PersonCheckingService personCheckingService;

    public BeerController(PersonCheckingService personCheckingService) {
        this.personCheckingService = personCheckingService;
    }
    @RequestMapping(value = "check",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response check(@RequestBody PersonToCheck personToCheck) {
        if( personCheckingService.shouldGetBeer(personToCheck))
            return new Response(BeerCheckStatus.OK);

        return new Response(BeerCheckStatus.NO_WAY);
    }

}


