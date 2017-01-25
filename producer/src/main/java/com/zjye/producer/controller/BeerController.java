package com.zjye.producer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

    @RequestMapping(value = "check",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response check(@RequestBody PersonToCheck personToCheck) {
        return null;
    }

}

interface PersonCheckingService {
    boolean shouldGetBeer(PersonToCheck personToCheck);
}

class Response {
    public BeerCheckStatus status;

    Response(BeerCheckStatus status) { this.status = status; }
}

enum BeerCheckStatus {
    OK,
    NO_WAY
}

class PersonToCheck {
    String name;
    String age;

    public PersonToCheck(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}


