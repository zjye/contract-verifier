package com.zjye.consumer.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class BeerVerificationListener {
    AtomicInteger eligibleCounter = new AtomicInteger();
    AtomicInteger notEligibleCounter = new AtomicInteger();

    @StreamListener(Sink.INPUT)
    public void handle(Verification verification) {
        if(verification.eligible)
            eligibleCounter.incrementAndGet();
        else
            notEligibleCounter.incrementAndGet();
    }


    public static class Verification {
        public boolean eligible;
    }

}
