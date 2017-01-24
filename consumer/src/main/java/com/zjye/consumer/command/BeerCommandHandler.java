package com.zjye.consumer.command;

import com.zjye.consumer.model.Response;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class BeerCommandHandler {
    RestTemplate restTemplate = new RestTemplate();
    public String execute(BeerCommand command) {
        ResponseEntity<Response> response = restTemplate.exchange(RequestEntity
                .post(URI.create("http://localhost:8090/check"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(command.getPerson()), Response.class);
        switch (response.getBody().status) {
            case OK:
                return "NAH";
            default:
                return "NO WAY";
        }
    }
}
