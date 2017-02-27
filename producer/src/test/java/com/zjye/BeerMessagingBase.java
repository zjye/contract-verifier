package com.zjye;

import com.zjye.producer.controller.PersonCheckingService;
import com.zjye.producer.controller.PersonToCheck;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierObjectMapper;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment= SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
@Import({
        ContractVerifierObjectMapper.class})
public abstract class BeerMessagingBase {

    @Inject
    MessageVerifier messaging;

    @Autowired
    PersonCheckingService personCheckingService;

    @Before
    public void setup() {
        this.messaging.receive("output", 100, TimeUnit.MICROSECONDS);
    }

    public void clientIsOldEnough() {
        personCheckingService.shouldGetBeer(new PersonToCheck(UUID.randomUUID().toString(), 25));
    }

    public void clientIsTooYoung() {
        personCheckingService.shouldGetBeer(new PersonToCheck(UUID.randomUUID().toString(), 5));
    }
}
