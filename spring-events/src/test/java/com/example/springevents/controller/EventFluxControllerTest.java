package com.example.springevents.controller;

import com.example.springevents.event.SpringEvent;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest
public class EventFluxControllerTest {
    @Autowired
    private WebTestClient client;

    @Test
    public void getMsg() throws Exception {

        client.get().uri("/flux/event").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(SpringEvent.class)
                .value(Matchers.notNullValue(SpringEvent.class));
    }

}