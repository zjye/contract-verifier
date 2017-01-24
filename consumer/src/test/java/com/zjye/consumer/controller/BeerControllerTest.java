package com.zjye.consumer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjye.consumer.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
        workOffline = true,
        ids = "com.zjye:producer:+:stubs:8090"
        // groupId:artifactId:version:stubs_classifier:port
)
public class BeerControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void should_give_me_beer() throws Exception {
        mockMvc.perform(post("/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new Person("foo", 22))))
                .andExpect(status().isOk())
                .andExpect(content().string("NAH"));
    }

    @Test
    public void should_reject_beer() throws Exception {
        mockMvc.perform(post("/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new Person("foo", 19))))
                .andExpect(status().isOk())
                .andExpect(content().string("NO WAY"));
    }
}