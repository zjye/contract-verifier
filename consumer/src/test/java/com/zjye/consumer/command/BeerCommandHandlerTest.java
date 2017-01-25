package com.zjye.consumer.command;

import com.zjye.consumer.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
        workOffline = true,
        ids = "com.zjye:producer:+:stubs:8090"
        // groupId:artifactId:version:stubs_classifier:port
)
public class BeerCommandHandlerTest {

    @Test
    public void should_give_me_beer() throws Exception {
        // arrange
        BeerCommand command = new BeerCommand();
        command.setPerson(new Person("foo", 22));
        BeerCommandHandler handler = new BeerCommandHandler();

        // act
        String result = handler.execute(command);

        // assert
        assertThat(result).isEqualTo("NAH");
    }

    @Test
    public void should_reject_beer() throws Exception {
        // arrange
        BeerCommand command = new BeerCommand();
        command.setPerson(new Person("foo", 19));
        BeerCommandHandler handler = new BeerCommandHandler();

        // act
        String result = handler.execute(command);

        // assert
        assertThat(result).isEqualTo("NO WAY");
    }
}