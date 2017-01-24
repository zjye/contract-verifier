package com.zjye.consumer.controller;

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

    @RequestMapping(value = "/beer",
            method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public String giveBeer(@RequestBody Person person) {
        RestTemplate restTemplate = new RestTemplate();

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

class Response {
    public ResponseStatus status;
}

enum ResponseStatus {
    OK, NOT_OK
}

class Person {
    private String name;
    private int age;

    public Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
