package com.zjye.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class DefaultPersonCheckingService implements PersonCheckingService {

    @Autowired
    private Source source;

    @Override
    public boolean shouldGetBeer(PersonToCheck personToCheck) {
        boolean shouldGetBeer = personToCheck.getAge()>=20;
        VerificationEvent event = new VerificationEvent(shouldGetBeer);
        source.output()
                .send(MessageBuilder.withPayload(event).build());
        return shouldGetBeer;
    }


}
