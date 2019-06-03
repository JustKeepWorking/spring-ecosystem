package com.example.springevents.controller;

import com.example.springevents.event.SpringEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RestController
public class EventFluxController {

    /**
     * Cannot detect with RequestHandledEvent
     * @return
     */
    @Bean
    RouterFunction<ServerResponse> getMessage() {
        return route(GET("/flux/event"),
                req -> ok().body(Mono.just(new SpringEvent("", "Hello")), SpringEvent.class));
    }
}
