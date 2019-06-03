package com.example.springevents.controller;

import com.example.springevents.event.SpringEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventRestController {
    @GetMapping("/rest/event")
    public SpringEvent getEvent() {
        return new SpringEvent("", "Event");
    }
}
