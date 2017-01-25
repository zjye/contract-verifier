package com.zjye;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.zjye.producer.controller.BeerController;
import com.zjye.producer.controller.PersonCheckingService;
import com.zjye.producer.controller.PersonToCheck;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.argThat;

@RunWith(MockitoJUnitRunner.class)
public abstract class BeerRestBase {
    @Mock
    PersonCheckingService personCheckingService;
    @InjectMocks
    BeerController beerController;


    @Before
    public void setup() {
        given(personCheckingService.shouldGetBeer(argThat(oldEnough()))).willReturn(true);
        RestAssuredMockMvc.standaloneSetup(beerController);
    }

    private TypeSafeMatcher<PersonToCheck> oldEnough() {
        return new TypeSafeMatcher<PersonToCheck>() {
            @Override
            protected boolean matchesSafely(PersonToCheck item) {
                return item.getAge() >= 20;
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}
