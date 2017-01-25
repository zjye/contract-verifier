package com.zjye.consumer.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
        workOffline = true,
        ids = "com.zjye:producer:+:stubs:8090"
        // groupId:artifactId:version:stubs_classifier:port
)
public class BeerVerificationListenerTest {

    @Autowired
    StubTrigger stubTrigger;
    @Autowired
    BeerVerificationListener listener;

    @Test
    public void should_increase_eligible_counter_when_positive_verification_took_place() {
        // arrange
        int initialCount = listener.eligibleCounter.get();

        // act
        this.stubTrigger.trigger("accepted_verification");

        // assert
        then(listener.eligibleCounter.get()).isGreaterThan(initialCount);
    }
    @Test
    public void should_increase_notEligible_counter_when_positive_verification_took_place() {
        // arrange
        int initialCount = listener.notEligibleCounter.get();

        // act
        this.stubTrigger.trigger("rejected_verification");

        // assert
        then(listener.notEligibleCounter.get()).isGreaterThan(initialCount);

    }
}