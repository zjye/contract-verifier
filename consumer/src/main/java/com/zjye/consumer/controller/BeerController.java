package com.zjye.consumer.controller;

import com.zjye.consumer.model.Person;
import com.zjye.consumer.model.Response;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
class BeerController {

    private RestTemplate restTemplate;

    @RequestMapping(value = "/beer",
            method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public String giveBeer(@RequestBody Person person) {
        this.restTemplate = new RestTemplate();
        ResponseEntity<Response> response = restTemplate.exchange(RequestEntity
                .post(URI.create("http://localhost:8090/check"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(person), Response.class);
        switch (response.getBody().status) {
            case OK:
                return "NAH";
            default:
                return "NO WAY";
        }
    }


}

