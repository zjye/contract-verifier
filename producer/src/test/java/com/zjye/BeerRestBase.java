package com.zjye;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.zjye.producer.controller.BeerController;
import org.junit.Before;

public abstract class BeerRestBase {
    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new BeerController());
    }
}
