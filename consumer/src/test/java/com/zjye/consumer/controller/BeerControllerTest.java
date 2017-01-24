package com.zjye.consumer.controller;

//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureJsonTesters
//@AutoConfigureStubRunner(
//        workOffline = true,
//        ids = "com.zjye:producer:+:stubs:8090"
//        // groupId:artifactId:version:stubs_classifier:port
//)
//public class BeerControllerTest {
//
//    @Autowired
//    protected MockMvc mockMvc;
//
//    @Test
//    public void should_give_me_beer() throws Exception {
//        mockMvc.perform(post("/beer")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(new Person("foo", 22))))
//                .andExpect(status().isOk())
//                .andExpect(content().string("NAH"));
//    }
//
//    @Test
//    public void should_reject_beer() throws Exception {
//        mockMvc.perform(post("/beer")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(new Person("foo", 19))))
//                .andExpect(status().isOk())
//                .andExpect(content().string("NO WAY"));
//    }
//}